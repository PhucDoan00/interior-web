/* eslint-disable @next/next/no-img-element */
import Link from 'next/link'
import Router from 'next/router'
import { useRouter } from 'next/router'
import Footer from '/components/footer'
import Layout from '/components/layout'
import Topbar from '/components/topbar'
import React, { useEffect, useState } from 'react'
import CardSlider from '/components/cardSlider'
import styles from '/styles/rooms/livingrooms.module.css'
import { getRoomsStyleById, getRoomId } from '/lib/designstyle'

import Cookies from 'js-cookie'

export default function LivingRoom() {
  const router = useRouter()
  const { roomId } = router.query
  const [roomStyle, setRoomStyle] = useState([])
  const [bigImg, setBigImg] = useState('')
  const [title, setTitle] = useState('')
  function setCookies(value) {
    Cookies.set('styleId', value, 86400)
  }
  const categoryId = (() => {
    const id = Cookies.get('categoryId')
    return id
  })()
  useEffect(() => {
    //Flag cleanUp to prevent memory leak
    let cleanUp = true
    async function fetchMyAPI() {
      const response = await getRoomsStyleById(roomId)
      if (cleanUp && response) {
        setRoomStyle(response.thumbnailList)
        setBigImg(response.bigImg)
        setTitle(response.categoryName)
      }
    }
    fetchMyAPI()
    return () => {
      cleanUp = false
    }
  }, [roomId])
  return (
    <>
      <div className={styles.stylesWrapper}>
        <section className={styles.imgSection}>
          <div className={styles.titlePos}>
            <p className={styles.title}> {`${title} Design Ideas`}</p>
          </div>
          <img className={styles.img} src={bigImg} alt="Main Img" />
        </section>
        <section className="roomStyles mb-5">
          <div className="container">
            <div className={styles.headertitle}>
              <h4>{` ${title} by style`}</h4>
            </div>
            <div className="row row-cols-2 row-cols-lg-4 g-2 g-lg-3">
              {/* Card */}
              {roomStyle.map((room, id) => (
                <div key={id} className="col">
                  <div className="p-0">
                    <Link href={`/rooms/${categoryId}/ideas/${room.styleId}`} passHref>
                      <button className={styles.btnCard} onClick={() => setCookies(room.styleId)}>
                        <div
                          className={`card ${styles.cardHover}`}
                          style={{ width: 18 + 'rem', height: 16 + 'rem' }}
                        >
                          <img
                            src={room.image}
                            className={`card-img-top ${styles.cardImg}`}
                            alt={room.styleName}
                          />
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
                onClick={() => Router.push('/rooms')}
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

export const getStaticPaths = async () => {
  const paths = await getRoomId()
  // console.log(paths)
  return {
    paths,
    fallback: false, // path nào ko return lại đc getStaticPaths thì trả về trang 404
  }
}

//get Data form BE
export const getStaticProps = async ({ params }) => {
  const roomList = await getRoomsStyleById(params.roomId)
  // console.log(designStyle)
  return {
    props: {
      roomList,
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
