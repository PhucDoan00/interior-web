/* eslint-disable @next/next/no-img-element */
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

      <section className="roomStyles">
        <div className="container">
          <div className="row row-cols-2 row-cols-lg-4 g-2 g-lg-3">
            <div className="col">
              <div className="p-3 border bg-light">Row column</div>
            </div>
            <div className="col">
              <div className="p-3 border bg-light">Row column</div>
            </div>
            <div className="col">
              <div className="p-3 border bg-light">Row column</div>
            </div>
            <div className="col">
              <div className="p-3 border bg-light">Row column</div>
            </div>
            <div className="col">
              <div className="p-3 border bg-light">Row column</div>
            </div>
            <div className="col">
              <div className="p-3 border bg-light">Row column</div>
            </div>
            <div className="col">
              <div className="p-3 border bg-light">Row column</div>
            </div>
            <div className="col">
              <div className="p-3 border bg-light">Row column</div>
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
      <Footer />
    </Layout>
  )
}
