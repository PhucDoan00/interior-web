/* eslint-disable jsx-a11y/alt-text */
/* eslint-disable @next/next/link-passhref */
/* eslint-disable @next/next/no-img-element */
import Link from 'next/link'
import Footer from '../../../components/footer'
import Layout from '../../../components/layout'
import Topbar from '../../../components/topbar'
import styles from '../../../styles/rooms/ideas/livingroomideas.module.css'
import LivingRoom from '../livingroom'

export default function LivingRoomIdeas() {
  console.log(<LivingRoom />)
  console.log('Hello gúys')
  return (
    <div className="livingWrapper">
      <section className={styles.imgSection}>
        <div className={styles.content}>
          <h2 className={styles.title}>Modern Living Room Design Ideas</h2>
          <p className={styles.paragraph}>
            Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget
            dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes,
          </p>
        </div>
      </section>

      <section>
        <h2>This is section where ideas is displayed</h2>
      </section>
    </div>
  )
}

LivingRoomIdeas.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <Footer />
    </Layout>
  )
}
