/* eslint-disable @next/next/link-passhref */
/* eslint-disable @next/next/no-img-element */
import Layout from '../../components/layout'
import Topbar from '../../components/topbar'
import Footer from '../../components/footer'
import styles from '../../styles/designIdeas.module.css'
import Link from 'next/link'
import CardSlider from '../../components/cardSlider'
import { getAllRooms } from '../../lib/designstyle'

export default function DesignIdeas({ rooms }) {
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
          {rooms.map((room, id) => (
            <Link href={`/rooms/${room.categoryId}`} key={id}>
              <div
                className={`card ${styles.cardHover}`}
                style={{ width: 13 + 'rem', height: 13 + 'rem' }}
              >
                <img src={room.image} className="card-img-top" alt={room.categoryName} />
                <h5 className={`card-title ${styles.cardTitle}`}>{room.categoryName}</h5>
              </div>
            </Link>
          ))}
        </div>
      </section>
    </div>
  )
}

export const getStaticProps = async () => {
  const rooms = await getAllRooms()
  return {
    props: {
      rooms,
    },
  }
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
