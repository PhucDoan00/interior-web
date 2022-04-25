/* eslint-disable @next/next/no-img-element */
import styles from '../../styles/Product.module.css'
import Carousel from 'react-bootstrap/Carousel'
import { useState, useEffect } from 'react'
import { useRouter } from 'next/router'
import { QuizImg } from '../../mock/dataForQuiz'
import { confirmAlert } from 'react-confirm-alert'
import 'react-confirm-alert/src/react-confirm-alert.css'

const ResultQuizSelect = () => {
  const [mainPicture, setMainPicture] = useState({})
  const router = useRouter()
  const [index, setIndex] = useState(1)
  // const [max, setMax] = useState(0)
  const [undefinedFlag, setUndefinedFlag] = useState(false)

  useEffect(() => {
    const op = QuizImg.find((e) => e.id === index)
    if (op) {
      setMainPicture(op)
    }
    var maxValue = 0
    var ind = 1
    for (var i = 1; i <= 8; i++) {
      if (maxValue < Number(localStorage.getItem(i.toString()))) {
        maxValue = localStorage.getItem(i.toString())
        ind = i
      }
    }
    setIndex(ind)
    for (var i = 1; i <= 8; i++) {
      if (Number(maxValue) == Number(localStorage.getItem(i.toString())) && i != ind) {
        console.log("set flag ", i)
        setUndefinedFlag(true)
      }
    }
  }, [index])

  const handleRedirectHome = () => {
    router.push('/')
  }

  const handleRedirectPage = () => {
    router.push('/rooms')
  }

  const handleRedirectMainQuiz = () => {
    router.push('/quiz')
  }

  function alert() {
    confirmAlert({
      title: 'Cannot define your style!',
      message: 'Do you want to take our Style Select again?',
      buttons: [
        {
          label: 'Yes',
          onClick: () => handleRedirectMainQuiz(),
        },
        {
          label: 'No',
          onClick: () => handleRedirectHome(),
        },
      ],
    })
  }

  return (

    <div className={`${styles.mt_400} ${styles['style-background']}`}>
      {!undefinedFlag ? (
        <div className={`container`}>
          <div className="row">
            <div className={`${styles['title-is']} col-4`}>Your style is</div>
          </div>
          <div className="row">
            <div className={`${styles['mid-century']} col-5`}>{mainPicture?.title}</div>
          </div>
          <div className="row">
            <div className={`${styles['content-title']} col-12`}>{mainPicture?.description}</div>
          </div>
          <div className="row mt-5">
            <div className="col-8">
              <img
                src={mainPicture.img}
                alt=""
                style={{
                  width: '100%',
                  height: '500px',
                  objectFit: 'cover',
                }}
              />
            </div>
          </div>
          <div className="row mt-5">
            <div className={`${styles['title-img']}`}>
              <div className={`${styles['title-imgLeft']}`}>
                Not sure if this is the right style of you?
              </div>
              <div className={`${styles['title-imgRight']}`}>
                <button className={`${styles['button-again']}`} onClick={handleRedirectMainQuiz}>
                  Take The Quiz Again!
                </button>
              </div>
            </div>
          </div>
          <div className={`row mt-5 ${styles.slide_components}`}>
            <div className={`${styles['content-slider']} mt-5`}>
              See how we bring real customer styles to life
            </div>
            <div className="row">
              <div className="col-10 m-auto">
                <Carousel>
                  <Carousel.Item>
                    <img
                      className="d-block w-100"
                      src="/quiz/pics1.jpg"
                      alt="First slide"
                      style={{ height: '400px', width: '100%', objectFit: 'container' }}
                    />
                  </Carousel.Item>
                  <Carousel.Item>
                    <img
                      className="d-block w-100"
                      src="/quiz/pics2.jpg"
                      alt="First slide"
                      style={{ height: '400px', width: '100%', objectFit: 'container' }}
                    />
                  </Carousel.Item>
                  <Carousel.Item>
                    <img
                      className="d-block w-100"
                      src="/quiz/pics3.jpg"
                      alt="First slide"
                      style={{ height: '400px', width: '100%', objectFit: 'container' }}
                    />
                  </Carousel.Item>
                  <Carousel.Item>
                    <img
                      className="d-block w-100"
                      src="/quiz/pics4.jpg"
                      alt="First slide"
                      style={{ height: '400px', width: '100%', objectFit: 'container' }}
                    />
                  </Carousel.Item>
                </Carousel>
              </div>
            </div>
            <div className="row mt-4">
              <button className={`${styles['button-browse']}`} onClick={handleRedirectPage}>
                Browse All Ideas
              </button>
            </div>
          </div>
        </div>
      ) : (
        alert()
      )};
    </div>
  )
}
export default ResultQuizSelect
