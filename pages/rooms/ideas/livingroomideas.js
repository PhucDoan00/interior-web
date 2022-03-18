/* eslint-disable jsx-a11y/alt-text */
/* eslint-disable @next/next/link-passhref */
/* eslint-disable @next/next/no-img-element */
import ButtonBack from '../../../components/buttonback'
import Footer from '../../../components/footer'
import Layout from '../../../components/layout'
import Topbar from '../../../components/topbar'
import styles from '../../../styles/rooms/ideas/livingroomideas.module.css'

const lvRoomStyles = [
  {
    styleName: 'Modern Living Room Brimming With Colors',
    img: '1.jpg',
  },
  {
    styleName: 'Modern and Transitional Living Room',
    img: '2.jpg',
  },
  {
    styleName: 'Modern Living Room With Mid-Century Inspired Furniture',
    img: '3.jpg',
  },
  {
    styleName: 'Modern and Minimalist Living Room',
    img: '4.jpg',
  },
  {
    styleName: 'Living Room With Pattern and Texture',
    img: '5.jpg',
  },
  {
    styleName: 'Modern Care-free Living Room',
    img: '6.jpg',
  },
  {
    styleName: 'Airy and Bright Modern Living Room',
    img: '7.jpg',
  },
  {
    styleName: 'Black and White Modern Living Room',
    img: '8.jpg',
  },
  {
    styleName: 'Modern Art Deco Living Room',
    img: '9.jpg',
  },
]

function LvRoomStyle({ styleName, img }) {
  return (
    <div className={`col-4 ${styles.column}`}>
      <div className={`p-0 me-5`}>
        <button className={styles.btnCard}>
          <div className={`card ${styles.cardHover}`}>
            <img
              src={`/designIdeas/livingroom/ideas/modern/${img}`}
              className={`card-img ${styles.cardImg}`}
              alt={styleName}
            />
            <div className={`card-img-overlay ${styles.imgOverlay} `}>
              <div className={`${styles.titlePos}`}>
                <h5 className={`card-title ${styles.cardTitle}`}>{styleName}</h5>
              </div>
            </div>
          </div>
        </button>
      </div>
    </div>
  )
}
export default function LivingRoomIdeas({title, setFlagShowIdeas}) {
  return (
    <>
      <section
        className={styles.imgSection}
        style={{ backgroundImage: 'url(/designIdeas/livingroom/ideas/mainImg.png)' }}
      >
        <div className={styles.content}>
          <h2 className={styles.title}>{title}Modern Living Room Design Ideas</h2>
          <p className={styles.paragraph}>
            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
            dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes,
          </p>
        </div>
      </section>

      <section className="roomStyles mt-5">
        <div className="container">
          <div className="row row-cols-3  g-2 g-lg-3 d-flex justify-content-center">
            {lvRoomStyles.map((styles, index) => (
              <LvRoomStyle key={index} styleName={styles.styleName} img={styles.img} />
            ))}
          </div>
        </div>
      </section>
      </>
  )
}
// row row-cols-2 row-cols-lg-3 g-2 g-lg-3
LivingRoomIdeas.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <Footer />
    </Layout>
  )
}
