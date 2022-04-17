/* eslint-disable @next/next/no-img-element */
// import React from 'react'
import Router from 'next/router'
import { useRouter } from 'next/router'
import Layout from '../../components/layout'
import Topbar from '../../components/topbar'
import Footer from '../../components/footer'
import React, { useEffect, useState } from 'react'
import { getDesignId, getLvRoomIdeasById } from '../../lib/designstyle'
import styles from '../../styles/rooms/ideas/livingroomideas.module.css'

export default function TestIdea() {
  const router = useRouter()
  const { id } = router.query
  // console.log(id)
  const [ideas, setIdeas] = useState([])
  const [des, setDes] = useState('')
  const [styleName, setStyleName] = useState('')
  const [image, setImage] = useState('')
  const [category, setCategory] = useState('')

  useEffect(() => {
    async function fetchMyAPI() {
      const response = await getLvRoomIdeasById(id)
      setIdeas(response.itemList)
      setDes(response.description)
      setStyleName(response.styleName)
      setImage(response.bigThumbnail)
      setCategory(response.categoryName)
    }
    fetchMyAPI()
  }, [id])

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
          <div className="btnWrapper">
            <button
              type="button"
              className={`btn ${styles.btnCustom} `}
              onClick={() => Router.push('/rooms/livingroom')}
            >
              Back
            </button>
          </div>
        </div>
      </section>
    </div>
  )
}

export const getStaticPaths = async () => {
  const paths = await getDesignId()
  // console.log(paths)
  return {
    paths,
    fallback: false, // path nào ko return lại đc getStaticPaths thì trả về trang 404
  }
}

export const getStaticProps = async ({ params }) => {
  const ideaLists = await getLvRoomIdeasById(params.id)
  // console.log(ideaLists)
  return {
    props: ideaLists,
  }
}

// export default TestIdea
TestIdea.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <Footer />
    </Layout>
  )
}
