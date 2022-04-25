/* eslint-disable @next/next/no-img-element */
import styles from '../../styles/Home.module.css'
import { useRouter } from 'next/router'
import { Quiz1 } from '../../mock/dataForQuiz'
import { useEffect, useState } from 'react'
import { Icon } from '@iconify/react'

const QuizOption = () => {
  const router = useRouter()
  const [listImgItem, setListImgItem] = useState([])
  const [listItemActive, setListItemActive] = useState([])
  const [mainPicture, setMainPicture] = useState({})
  const [check, setCheck] = useState(0)
  useEffect(() => {
    const op = JSON.parse(localStorage.getItem('picture'))
    if (op) {
      setMainPicture(op)
      setListImgItem(Quiz1)
    }
  }, [])

  const handleBack = () => {
    router.push('/quiz')
  }

  const getPoint = (id) => {
    const oldPoint = localStorage.getItem(id)
    const newPoint = Number(oldPoint) + 2
    localStorage.setItem(id, newPoint)
  }

  const handleResult = () => {
    getPoint(listItemActive[0])
    getPoint(listItemActive[1])
    getPoint(listItemActive[2])
    router.push('/quiz/option2')
  }

  const handleActiveImg = (id) => {
    let data = listItemActive.find((item) => item == id)
    if (data) {
      let newList = [...listItemActive]
      newList = newList.filter((e) => e != data)
      setListItemActive([...newList])
      setCheck(check - 1)
    } else {
      // if (listItemActive.length >= 3) {
      //   alert('Ban chi duoc chon toi da 3 anhh')
      // } else {
      setListItemActive([...listItemActive, id])
      setCheck(check + 1)
      // }
    }
  }

  const checkActive = (id) => {
    let data = listItemActive.find((item) => item == id)
    if (data) {
      return `${styles.active}`
    } else {
      return `${styles.no_active}`
    }
  }

  return (
    <div className={styles.mt_404}>
      <div className="container">
        <div className="row">
          <div className={`col-sm-6 ${styles.leftQuiz}`}>
            <div className={`${styles.contentLeftQuiz}`}>
              <div className={`${styles.topLeftQuiz} pb-2`}>
                <h2>Select the pieces that you like</h2>
              </div>
              <div className="pt-2">
                <h4 className={`${styles.bottomLeftQuiz}`}>
                  Here are products inspired by your room choice
                </h4>
              </div>
            </div>
          </div>

          <div className={`col-sm-6 ${styles.rightQuiz}`}>
            <div className={`row pt-2 pb-3`}>
              {/*  */}
              <div className={`col-sm-12 p-2 ${styles.cursor}`}>
                <img
                  className={`${styles.picRightQuiz}`}
                  src={mainPicture?.img}
                  style={{
                    height: '300px',
                    objectFit: 'cover',
                  }}
                  alt=""
                />
              </div>
              {/* main */}
              {listImgItem?.map((e) => (
                <div
                  key={e.id}
                  className={`col-sm-4 p-2 ${styles.cursor}`}
                  onClick={() => handleActiveImg(e.id)}
                >
                  <img className={styles.pickRightProduct} src={e.img} alt="" />
                  <div className={checkActive(e.id)}>
                    <Icon
                      icon="akar-icons:circle-check-fill"
                      fontSize={24}
                      style={{
                        backgroundColor: 'green',
                        color: 'white',
                        borderRadius: '50%',
                      }}
                    />
                  </div>
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
      <div className={`${styles.bottomBar}`}>
        <div className={`${styles.bottomQuiz}`}>
          <button className={`${styles.btnBack}`} onClick={handleBack}>
            <span>Retry</span>
          </button>
          {check > 0 && (
            <button className={`${styles.btnSelected}`} onClick={handleResult}>
              <span>Next</span>
            </button>
          )}
        </div>
      </div>
    </div>
  )
}

export default QuizOption
