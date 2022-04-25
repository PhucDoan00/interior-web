/* eslint-disable @next/next/no-img-element */
import styles from '../../styles/Home.module.css'
import { Icon } from '@iconify/react'
import { QuizImg } from '../../mock/dataForQuiz'
import { useState } from 'react'
import { useRouter } from 'next/router'

const QuizSelect = () => {
  const [listActive, setListActive] = useState([])
  const [number, setNumber] = useState(0)
  const router = useRouter()
  for (var i = 0; i <= 8; i++) {
    localStorage.setItem(i.toString(), 0);
  }

  const handleActiveImg = (id) => {
    let data = listActive.find((item) => item == id)

    if (data) {
      let newList = [...listActive]
      newList = newList.filter((e) => e != data)
      setNumber(number - 1)
      setListActive([...newList])
    } else {
      if (listActive.length >= 3) {
        alert('Ban chi duoc chon toi da 3 anhh')
      } else {
        setNumber(number + 1)

        setListActive([...listActive, id])
      }
    }
  }

  const checkActive = (id) => {
    let data = listActive.find((item) => item == id)
    if (data) {
      return `${styles.active}`
    } else {
      return `${styles.no_active}`
    }
  }

  const getPoint = (id) => {
    const oldPoint = localStorage.getItem(id)
    const newPoint = Number(oldPoint) + 5
    localStorage.setItem(id, newPoint)
  }

  const handleNextPage = () => {
    localStorage.removeItem('picture')
    localStorage.removeItem('picture1')
    localStorage.removeItem('picture2')
    let op = QuizImg.find((e) => e.id === listActive[0])
    let op1 = QuizImg.find((e) => e.id === listActive[1])
    let op2 = QuizImg.find((e) => e.id === listActive[2])
    localStorage.setItem('picture', JSON.stringify(op))
    localStorage.setItem('picture1', JSON.stringify(op1))
    localStorage.setItem('picture2', JSON.stringify(op2))
    getPoint(listActive[0])
    getPoint(listActive[1])
    getPoint(listActive[2])
    router.push('/quiz/option')
  }

  return (
    <div className={styles.mt_404}>
      <div className="container ">
        <div className="row">
          <div className={`col-sm-6 ${styles.leftQuiz}`}>
            <div className={`${styles.contentLeftQuiz}`}>
              <div className={`${styles.topLeftQuiz} pb-2`}>
                <h2>Which 3 rooms appeal to you most?</h2>
              </div>
              <div className="pt-2">
                <h4 className={`${styles.bottomLeftQuiz}`}>
                  Show us what your dream home look like
                </h4>
              </div>
            </div>
          </div>

          <div className={`col-sm-6 ${styles.rightQuiz}`}>
            <div className={`row pt-2 pb-3`}>
              {QuizImg.map((e) => (
                <div
                  key={e.id}
                  className={`col-sm-6 p-2 ${styles.cursor}`}
                  onClick={() => handleActiveImg(e.id)}
                >
                  <img
                    className={`${styles.picRightQuiz}`}
                    src={e.img}
                    style={{
                      height: '200px',
                      objectFit: 'cover',
                    }}
                    alt=""
                  />
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
          {number === 3 ? (
            <button className={`${styles.btnSelected}`} onClick={handleNextPage}>
              <span>Next</span>
            </button>
          ) : (
            <button className={`${styles.btnSelected}`}>
              <span>{number}/3 Selected</span>
            </button>
          )}
        </div>
      </div>
    </div>
  )
}

export default QuizSelect
