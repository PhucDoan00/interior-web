/* eslint-disable @next/next/link-passhref */
/* eslint-disable @next/next/no-img-element */
import Layout from '../components/layout'
import Topbar from '../components/topbar'
import Footer from '../components/footer'
import styles from '../styles/designIdeas.module.css'
import Link from 'next/link'
import CardSlider from '../components/cardSlider'

export default function DesignIdeas() {
  return (
    <div className={styles.designWrapper}>
      <section className={styles.imageSection}>
        <div className={styles.content}>
          <div className={styles.text}>
            <p>{'"The details are not the details. They make the design"'}</p>
          </div>
          <div className={styles.line}></div>
        </div>
      </section>

      <section className={styles.rooms}>
        <div className="title my-5">
          <h3>Select Room Category</h3>
        </div>
        <div className={` mb-5 justify-content-evenly ${styles.category}`}>
          <Link href="/rooms/livingroom">
            <div className="card" style={{ width: 13 + 'rem', height: 13 + 'rem' }}>
              <img src="/designIdeas/living.jpg" className="card-img-top" alt="Living Room" />
              <h5 className={`card-title ${styles.cardTitle}`}>Living Room</h5>
            </div>
          </Link>
          <Link href="/rooms/bedroom">
            <div className="card" style={{ width: 13 + 'rem' }}>
              <img src="/designIdeas/bed.jpg" className="card-img-top" alt="Bed Room" />
              <h5 className={`card-title ${styles.cardTitle}`}>Bed Room</h5>
            </div>
          </Link>
          <Link href="/rooms/diningroom">
            <div className="card" style={{ width: 13 + 'rem' }}>
              <img src="/designIdeas/dining.jpg" className="card-img-top" alt="Dining Room" />
              <h5 className={`card-title ${styles.cardTitle}`}>Dining Room</h5>
            </div>
          </Link>
          <Link href="/rooms/office">
            <div className="card" style={{ width: 13 + 'rem' }}>
              <img src="/designIdeas/office.jpg" className="card-img-top" alt="Office" />
              <h5 className={`card-title ${styles.cardTitle}`}>Office</h5>
            </div>
          </Link>
          <Link href="/rooms/kidsroom">
            <div className="card" style={{ width: 13 + 'rem' }}>
              <img src="/designIdeas/kids.jpg" className="card-img-top" alt="Kid's Room" />
              <h5 className={`card-title ${styles.cardTitle}`}>{`Kid's Room`}</h5>
            </div>
          </Link>
          <Link href="/rooms/nursey">
            <div className="card" style={{ width: 13 + 'rem' }}>
              <img src="/designIdeas/nursey.jpg" className="card-img-top" alt="Nursey" />
              <h5 className={`card-title ${styles.cardTitle}`}>Nursey</h5>
            </div>
          </Link>
        </div>
      </section>
    </div>
  )
}

DesignIdeas.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <CardSlider />
      <Footer />
    </Layout>
  )
}
