/* eslint-disable @next/next/link-passhref */
/* eslint-disable @next/next/no-img-element */
import Link from 'next/link'
import CardSlider from '../../components/cardSlider'
import Footer from '../../components/footer'
import Layout from '../../components/layout'
import Topbar from '../../components/topbar'
import styles from '../../styles/rooms/livingrooms.module.css'
import React, { useEffect } from 'react'
import ButtonBack from '../../components/buttonback'

const rooms = [
  {
    id: 1,
    roomStyle: 'Modern Living Room Ideas',
    img: '/designIdeas/livingroom/6.png',
  },
  {
    id: 2,
    roomStyle: 'Mid-Century Living Room Ideas',
    img: '/designIdeas/livingroom/5.png',
  },
  {
    id: 3,
    roomStyle: 'Rustic Living Room Ideas',
    img: '/designIdeas/livingroom/8.png',
  },
  {
    id: 4,
    roomStyle: 'Eclectic Living Room Ideas',
    img: '/designIdeas/livingroom/7.png',
  },
  {
    id: 5,
    roomStyle: 'Coastal Living Room Ideas',
    img: '/designIdeas/livingroom/4.png',
  },
  {
    id: 6,
    roomStyle: 'Industrial Living Room Ideas',
    img: '/designIdeas/livingroom/3.png',
  },
  {
    id: 7,
    roomStyle: 'Traditional Living Room Ideas',
    img: '/designIdeas/livingroom/1.png',
  },
  {
    id: 8,
    roomStyle: 'Glam Living Room Ideas',
    img: '/designIdeas/livingroom/2.png',
  },
]

function Living({ roomStyle, img }) {
  return (
    <div className="col">
      <div className="p-0">
        {/* Card_Button */}
        <button className={styles.btnCard}>
          <div
            className={`card ${styles.cardHover}`}
            style={{ width: 18 + 'rem', height: 16 + 'rem' }}
          >
            <img src={img} className="card-img-top" alt={roomStyle} />
            <h5 className={`card-title ${styles.cardTitle}`}>{roomStyle}</h5>
          </div>
        </button>
      </div>
    </div>
  )
}
export default function LivingRoom() {
  return (
    <div className="livingWrapper">
      <section className={styles.imgSection}>
        <img className={styles.img} src="../../designIdeas/livingroom/mainImg.png" alt="Main Img" />
        <p className={styles.title}>Living Room Design Ideas</p>
      </section>

      <section className="roomStyles mb-5">
        <div className="container">
          <div className={` ${styles.headertitle}`}>
            <h4> Living rooms by style</h4>
          </div>
          <div className="row row-cols-2 row-cols-lg-4 g-2 g-lg-3">
            {/* Card */}
            {rooms.map((room, index) => (
              <Living key={index} roomStyle={room.roomStyle} img={room.img} />
            ))}
          </div>
        </div>
        <div className="container my-3">
          <ButtonBack />
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
