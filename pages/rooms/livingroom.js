/* eslint-disable @next/next/no-img-element */
import CardSlider from '../../components/cardSlider'
import Footer from '../../components/footer'
import Layout from '../../components/layout'
import Topbar from '../../components/topbar'
import styles from '../../styles/rooms/livingrooms.module.css'

export default function LivingRoom() {
  return (
    <div className="livingWrapper">
      <section className={styles.imgSection}>
        <img className={styles.img} src="../../designIdeas/livingroom/mainImg.png" alt="Main Img" />
        <p className={styles.title}>Living Room Design Ideas</p>
      </section>

      <section className="roomStyles mb-5">
        <div className="container">
          <div className="row row-cols-2 row-cols-lg-4 g-2 g-lg-3">
            {/* 1st col */}
            <div className="col">
              <div className="p-0">
                {/* Card */}
                <div
                  className={`card ${styles.cardHover}`}
                  style={{ width: 18 + 'rem', height: 16 + 'rem' }}
                >
                  <img src="/designIdeas/livingroom/6.png" className="card-img-top" alt="Office" />
                  <h5 className={`card-title ${styles.cardTitle}`}>Modern Living Room Ideas</h5>
                </div>
              </div>
            </div>
            {/* 2nd col */}
            <div className="col">
              <div className="p-0">
                {/* Card */}
                <div
                  className={`card ${styles.cardHover}`}
                  style={{ width: 18 + 'rem', height: 16 + 'rem' }}
                >
                  <img src="/designIdeas/livingroom/5.png" className="card-img-top" alt="Office" />
                  <h5 className={`card-title ${styles.cardTitle}`}>
                    Mid-Century Living Room Ideas
                  </h5>
                </div>
              </div>
            </div>
            {/* 3rd col */}
            <div className="col">
              <div className="p-0">
                {/* Card */}
                <div
                  className={`card ${styles.cardHover}`}
                  style={{ width: 18 + 'rem', height: 16 + 'rem' }}
                >
                  <img src="/designIdeas/livingroom/8.png" className="card-img-top" alt="Office" />
                  <h5 className={`card-title ${styles.cardTitle}`}>Rustic Living Room Ideas</h5>
                </div>
              </div>
            </div>
            {/* 4th col */}
            <div className="col">
              <div className="p-0">
                {/* Card */}
                <div
                  className={`card ${styles.cardHover}`}
                  style={{ width: 18 + 'rem', height: 16 + 'rem' }}
                >
                  <img src="/designIdeas/livingroom/7.png" className="card-img-top" alt="Office" />
                  <h5 className={`card-title ${styles.cardTitle}`}>Eclectic Living Room Ideas</h5>
                </div>
              </div>
            </div>
            {/* 5th col */}
            <div className="col">
              <div className="p-0">
                {/* Card */}
                <div
                  className={`card ${styles.cardHover}`}
                  style={{ width: 18 + 'rem', height: 16 + 'rem' }}
                >
                  <img src="/designIdeas/livingroom/4.png" className="card-img-top" alt="Office" />
                  <h5 className={`card-title ${styles.cardTitle}`}>Coastal Living Room Ideas</h5>
                </div>
              </div>
            </div>
            {/* 6th col */}
            <div className="col">
              <div className="p-0">
                {/* Card */}
                <div
                  className={`card ${styles.cardHover}`}
                  style={{ width: 18 + 'rem', height: 16 + 'rem' }}
                >
                  <img src="/designIdeas/livingroom/3.png" className="card-img-top" alt="Office" />
                  <h5 className={`card-title ${styles.cardTitle}`}>Industrial Living Room Ideas</h5>
                </div>
              </div>
            </div>
            {/* 7th col */}
            <div className="col">
              <div className="p-0">
                {/* Card */}
                <div
                  className={`card ${styles.cardHover}`}
                  style={{ width: 18 + 'rem', height: 16 + 'rem' }}
                >
                  <img src="/designIdeas/livingroom/1.png" className="card-img-top" alt="Office" />
                  <h5 className={`card-title ${styles.cardTitle}`}>
                    Traditional Living Room Ideas
                  </h5>
                </div>
              </div>
            </div>
            {/* 8th col */}
            <div className="col">
              <div className="p-0">
                {/* Card */}
                <div
                  className={`card ${styles.cardHover}`}
                  style={{ width: 18 + 'rem', height: 16 + 'rem' }}
                >
                  <img src="/designIdeas/livingroom/2.png" className="card-img-top" alt="Office" />
                  <h5 className={`card-title ${styles.cardTitle}`}>Glam Living Room Ideas</h5>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  )
}

LivingRoom.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <CardSlider />
      <Footer />
    </Layout>
  )
}
