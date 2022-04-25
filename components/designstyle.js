import styles from './designstyle.module.css'
import React from 'react'
import Image from 'next/image'
import Link from 'next/link'

export default function Designstyle() {
  return (
    <div className="container">
      <div
        className="row justify-content-around"
        style={{
          margin: '80px 0',
        }}
      >
        <div className={`col-4 ${styles.colImg}`}>
          <Image src={'/yourDesign/15.png'} width="400" height="400" alt="img" />
        </div>
        <div className="col-4">
          <div>
            <p className={styles.a}> What’s Your Design Style </p>
            <p className={styles.b}>
              Not sure whether your style is Bohemian, Glam, or Midcentury Modern? Our STYLE SELECT
              will helps you uncover your unique design style. Once you have your personalized
              results, our ideas can help you find your a home you love living in.
            </p>
            <div className="row">
              <div className="col-4">
                <Link href="/stylequiz" passHref>
                  <button
                    type="button"
                    className={`btn btn-outline mx-2 ${styles.btnCustomOutlinePrimary}`}
                  >
                    Take Style Quiz
                  </button>
                </Link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}
