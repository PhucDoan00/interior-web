/* eslint-disable @next/next/link-passhref */
/* eslint-disable @next/next/no-img-element */
import CardSlider from '../../components/cardSlider'
import Footer from '../../components/footer'
import Layout from '../../components/layout'
import Topbar from '../../components/topbar'
import styles from '../../styles/rooms/livingrooms.module.css'
import React, { useEffect } from 'react'
import LivingRoomIdeas from './ideas/livingroomideas'
import { useState } from 'react'
import Router from 'next/router'
import { getDesignStyleLivingRoom } from '../../lib/designstyle'

// const rooms = [
//   {
//     id: 1,
//     roomStyle: 'Modern Living Room Ideas',
//     img: '6.png',
//     imgBackGround: 'modern.png',
//     paragraph:
//       "Modern design is all about chic furniture and statement pieces. For a modern living room, you'll want to blend sleek elements with comfort. To achieve a livable modern living room, find cozy fabrics and plush rugs, and pair them with striking decor and materials!",
//   },

//   {
//     id: 2,
//     roomStyle: 'Mid-Century Living Room Ideas',
//     img: '5.png',
//     imgBackGround: 'midcentury.png',
//     paragraph:
//       'A mid-century modern living room layout is characterized by its uncluttered design and clean lines. This iconic style blends comfort with modern design elements and a retro aesthetic. There’s something nostalgic about mid-century modern design—which makes sense since it first came on the scene after WWII',
//   },
//   {
//     id: 3,
//     roomStyle: 'Rustic Living Room Ideas',
//     img: '8.png',
//     imgBackGround: 'rustic.png',
//     paragraph:
//       "A living room is just that; a space where we live! It's used for a multitude of needs, from TV watching, family game nights, gathering of friends, solo reading afternoons and everything in between. This means a living room needs to be both beautiful and functional. A sofa should be both something you enjoy looking at.For those reasons, we can't think of a cozier style than Rustic.",
//   },
//   {
//     id: 4,
//     roomStyle: 'Eclectic Living Room Ideas',
//     img: '7.png',
//     imgBackGround: 'eclectic.png',
//     paragraph:
//       'If a space that is both approachable and informal, globally-inspired and multi-style and highly curated sounds like your cup of tea, than an eclectic living room design may be what you need. Eclectic style is all about mixing elements and covers a wide range of looks from bohemian to more elegant and polished',
//   },
//   {
//     id: 5,
//     roomStyle: 'Coastal Living Room Ideas',
//     img: '4.png',
//     imgBackGround: 'coastal.png',
//     paragraph:
//       'Whether you have a beach cottage or just want an easy living room reminiscent of the seaside, coastal style design is a beautiful solution. With staples like white linen sofas, natural fibers, and weathered woods, coastal living rooms are nothing short of airy and inviting!',
//   },
//   {
//     id: 6,
//     roomStyle: 'Industrial Living Room Ideas',
//     img: '3.png',
//     imgBackGround: 'industrial.png',
//     paragraph:
//       "Effortlessly cool. Easy going. Undeniably chic. These are all aspects of an industrial-style living room. Exposed brick, piping, concrete or natural wood floors are structural elements that make Industrial style what it is, but even if your home is anything but Industrial, don't despair; you can still bring this coveted cool look to your home with the right decor and furniture!",
//   },
//   {
//     id: 7,
//     roomStyle: 'Traditional Living Room Ideas',
//     img: '1.png',
//     imgBackGround: 'traditional.png',
//     paragraph:
//       'Traditional design is classic and elegant. A traditional living room can be both timeless and cozy for the whole family. It all depends on the materials used. However, every traditional living room design does have a discerning color palette, curated artwork and decor, and elegant lighting that makes a statement',
//   },
//   {
//     id: 8,
//     roomStyle: 'Glam Living Room Ideas',
//     img: '2.png',
//     imgBackGround: 'glam.png',
//     paragraph:
//       "A glam living room design is for you if you want your living space to make a show-stopping statement. Glam living rooms tend to be more polished and upscale, and often make a pretty bold statement. They're great for entertaining, with their highly styled and considered approach.",
//   },
// ]

function Living({
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
            <img src={image} className="card-img-top" alt={styleName} />
            <h5 className={`card-title ${styles.cardTitle}`}>{styleName}</h5>
          </div>
        </button>
      </div>
    </div>
  )
}
export default function LivingRoom({ designStyle }) {
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
                  {designStyle.thumbnailList.map((room, index) => (
                    <Living
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
          <LivingRoomIdeas
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
  const designStyle = await getDesignStyleLivingRoom()
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
