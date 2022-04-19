/* eslint-disable @next/next/no-img-element */
import Layout from '../../components/layout'
import Topbar from '../../components/topbar'
import Footer from '../../components/footer'
// import styles from '../../styles/StyleQuiz.module.css'
import styles from '/styles/rooms/detail.module.css'
import Link from 'next/link'
import Router from 'next/router'
import { useRouter } from 'next/router'
import Image from 'next/image'
import ProductSmall from '../../components/productSmall'
import { getListProduct, getDetailIdeaById } from '../../lib/designstyle'
import { useState, useEffect } from 'react'

export default function IdeaDetail() {
  const router = useRouter()
  const { detailId } = router.query
  const [title, setTitle] = useState('')
  const [des, setDes] = useState('')
  const [bigImg, setBigImg] = useState('')
  const [listProduct, setListProduct] = useState([])

  useEffect(() => {
    let cleanUp = true
    async function fetchApi() {
      const data = await getDetailIdeaById(detailId)
      if (cleanUp && data) {
        setListProduct(data.itemList)
        setTitle(data.designIdeaName)
        setDes(data.designIdeaDescription)
        setBigImg(data.image)
      }
    }
    fetchApi()
    return () => {
      cleanUp = false
    }
  }, [detailId])
  return (
    <div className={`container ${styles.body}`}>
      <div className="container">
        <section className={`img ${styles.bigImg}`}>
          <div className={`content ${styles.content}`}>
            <h1 className={`${styles.contentTitle}`}>{title}</h1>
            <p className={styles.contentDes}>{des}</p>
          </div>
          <div className={`img-fluid ${styles.styelImg}`}>
            <img src={bigImg} alt="background" className={styles.imgSize} />
          </div>
        </section>

        <section className={styles.productSection}>
          <div className="row">
            <div className="col-sm-1"></div>
            <h2 className="col-sm-10"> Furniture and decore in this room</h2>
          </div>
          <div className="row " style={{ marginTop: '30px' }}>
            <div className="col-sm-1"></div>
            <div className="col-sm-10">
              <div className="row d-flex">
                {listProduct?.map((e, index) => (
                  <ProductSmall
                    key={index}
                    imgPath={e.image}
                    name={e.productName}
                    price={e.price}
                    id={e.productId}
                  />
                ))}
              </div>
            </div>
            <div className="col-sm-1"></div>
          </div>
        </section>
      </div>
    </div>
  )
}

IdeaDetail.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <Footer />
    </Layout>
  )
}
