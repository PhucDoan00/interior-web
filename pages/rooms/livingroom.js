/* eslint-disable @next/next/link-passhref */
/* eslint-disable @next/next/no-img-element */
import Link from 'next/link'
import Router from 'next/router'
import Footer from '../../components/footer'
import Layout from '../../components/layout'
import Topbar from '../../components/topbar'
import CardSlider from '../../components/cardSlider'
import styles from '../../styles/rooms/livingrooms.module.css'
import { getDesignStyleByRoom } from '../../lib/designstyle'
export default function LivingRoom({ designStyle }) {
  return (
    <>
      <div className="livingWrapper">
        <section className={styles.imgSection}>
          <img
            className={styles.img}
            src="../../designIdeas/livingroom/mainImg.png"
            alt="Main Img"
          />
          <p className={styles.title}>Living Room Design Ideas</p>
        </section>
        <section className="roomStyles mb-5">
          <div className="container">
            <div className={` ${styles.headertitle}`}>
              <h4> Living room by style</h4>
            </div>
            <div className="row row-cols-2 row-cols-lg-4 g-2 g-lg-3">
              {/* Card */}
              {designStyle.thumbnailList.map((room, styleId) => (
                <div key={styleId} className="col">
                  <div className="p-0">
                    <Link href={`/rooms/${room.styleId}`}>
                      <button className={styles.btnCard}>
                        <div
                          className={`card ${styles.cardHover}`}
                          style={{ width: 18 + 'rem', height: 16 + 'rem' }}
                        >
                          <img src={room.image} className="card-img-top" alt={room.styleName} />
                          <h5 className={`card-title ${styles.cardTitle}`}>{room.styleName}</h5>
                        </div>
                      </button>
                    </Link>
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
                onClick={() => Router.push('/designIdeas')}
              >
                Back
              </button>
            </div>
          </div>
        </section>
      </div>
      <CardSlider />
    </>
  )
}

//get Data form BE
export const getStaticProps = async () => {
  const designStyle = await getDesignStyleByRoom('5')
  // console.log(designStyle)
  return {
    props: {
      designStyle,
    },
  }
}

LivingRoom.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <Footer />
    </Layout>
  )
}
