/* eslint-disable @next/next/no-img-element */
// import React from 'react'
import Router from 'next/router'
import { useRouter } from 'next/router'
import Layout from '/components/layout'
import Topbar from '/components/topbar'
import Footer from '/components/footer'
import React, { useEffect, useState } from 'react'
import { getIdeasByStyleId } from '/lib/designstyle'
import styles from '/styles/rooms/ideas/livingroomideas.module.css'
import Cookies from 'js-cookie'

export default function TestIdea({}) {
  const router = useRouter()
  const { id } = router.query
  const [ideas, setIdeas] = useState([])
  const [des, setDes] = useState('')
  const [styleName, setStyleName] = useState('')
  const [image, setImage] = useState('')
  const [category, setCategory] = useState('')

  const categoryId = (() => {
    const id = Cookies.get('categoryId')
    return id
  })()
  useEffect(() => {
    //Flag cleanUp to prevent memory leak
    let cleanUp = true
    async function fetchMyAPI() {
      const response = await getIdeasByStyleId(categoryId, id)
      if (cleanUp && response) {
        setIdeas(response.itemList)
        setDes(response.description)
        setStyleName(response.styleName)
        setImage(response.bigThumbnail)
        setCategory(response.categoryName)
      }
    }
    fetchMyAPI()
    return () => {
      cleanUp = false
    }
  })

  return (
    <div>
      <section className={styles.imgSection} style={{ backgroundImage: `url(${image})` }}>
        <div className={styles.content}>
          <h2 className={styles.title}>
            {styleName} {category}
          </h2>
          <p className={styles.paragraph}>{des}</p>
        </div>
      </section>
      <section className="roomStyles mt-5">
        <div className="container">
          <div className="row row-cols-3  g-2 g-lg-3 d-flex justify-content-center">
            {ideas.map((idea, id) => (
              <div className={`col-4 ${styles.column}`} key={id}>
                <div className={`p-0 me-5`}>
                  <button className={styles.btnCard}>
                    <div className={`card ${styles.cardHover}`}>
                      <img
                        src={idea.image}
                        className={`card-img ${styles.cardImg}`}
                        alt={idea.designIdeaName}
                      />
                      <div className={`card-img-overlay ${styles.imgOverlay} `}>
                        <div className={`${styles.titlePos}`}>
                          <h5 className={`card-title ${styles.cardTitle}`}>
                            {idea.designIdeaName}
                          </h5>
                        </div>
                      </div>
                    </div>
                  </button>
                </div>
              </div>
            ))}
          </div>
        </div>
        <div className="container">
          <div className={`btnWrapper ${styles.btnPos}`}>
            <button
              type="button"
              className={`btn ${styles.btnCustom} `}
              onClick={() => Router.push(`/rooms/${categoryId}`)}
            >
              Back
            </button>
          </div>
        </div>
      </section>
    </div>
  )
}

TestIdea.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <Footer />
    </Layout>
  )
}
