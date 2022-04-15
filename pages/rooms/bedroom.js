/* eslint-disable @next/next/no-img-element */
import Router from 'next/router'
import { useState } from 'react'
import React, { useEffect } from 'react'
import Footer from '../../components/footer'
import Layout from '../../components/layout'
import Topbar from '../../components/topbar'
import BedRoomIdeas from './ideas/bedroomideas'
import CardSlider from '../../components/cardSlider'
import styles from '../../styles/rooms/bedrooms.module.css'
import { getDesignStyleByRoom } from '../../lib/designstyle'

function BedRoomStyle({
  styleName,
  image,
  imageBig,
  description,
  handleShowInfo,
  handleTitle,
  handleImgBackGround,
  handlePara,
}) {
  return (
    <div className="col">
      <div className="p-0">
        {/* Card_Button */}
        <button
          className={styles.btnCard}
          onClick={() => (
            handleShowInfo(false),
            handleTitle(styleName),
            handleImgBackGround(imageBig),
            handlePara(description)
          )}
        >
          <div
            className={`card ${styles.cardHover}`}
            style={{ width: 18 + 'rem', height: 16 + 'rem' }}
          >
            <img src={image} className={`card-img-top ${styles.cardImg}`} alt={styleName} />
            <h5 className={`card-title ${styles.cardTitle}`}>{styleName}</h5>
          </div>
        </button>
      </div>
    </div>
  )
}
export default function BedRoom({ designStyle }) {
  const [flagShowIdeas, setFlagShowIdeas] = useState(true)
  const [styleName, setTitle] = useState('')
  const [imageBig, setImgBackground] = useState('')
  const [paragrah, setParagraph] = useState('')
  useEffect(() => {
    window.scrollTo(0, 0)
  }, [flagShowIdeas])

  return (
    <>
      {flagShowIdeas ? (
        <>
          <div className="bedroomWrapper">
            <section className={styles.imgSection}>
              <img src="/designIdeas/bedroom/mainImgBR.png" alt="Bedroom" className={styles.img} />
              <p className={styles.title}>Bed Room Design Ideas</p>
            </section>
            <section className="roomStyles mb-5">
              <div className="container">
                <div className={` ${styles.headertitle}`}>
                  <h4> Bed room by style</h4>
                </div>
                <div className="row row-cols-2 row-cols-lg-4 g-2 g-lg-3">
                  {/* Card */}
                  {designStyle.thumbnailList.map((room, index) => (
                    <BedRoomStyle
                      key={index}
                      styleName={room.styleName}
                      image={room.image}
                      imageBig={room.imageBig}
                      description={room.description}
                      handleShowInfo={setFlagShowIdeas}
                      handleTitle={setTitle}
                      handleImgBackGround={setImgBackground}
                      handlePara={setParagraph}
                    />
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
      ) : (
        <div className="livingWrapper">
          <BedRoomIdeas
            styleName={styleName}
            imageBig={imageBig}
            paragrah={paragrah}
            handleShowInfo={setFlagShowIdeas}
          />
          <div className="container">
            <div className="btnWrapper">
              <button
                type="button"
                className={`btn ${styles.btnCustomLVIdeas} `}
                onClick={() => {
                  setFlagShowIdeas(true)
                }}
              >
                Back
              </button>
            </div>
          </div>
        </div>
      )}
    </>
  )
}

//get Data form BE
export const getStaticProps = async () => {
  const designStyle = await getDesignStyleByRoom('1')
  return {
    props: {
      designStyle,
    },
  }
}

BedRoom.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <Footer />
    </Layout>
  )
}
