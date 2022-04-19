/* eslint-disable react/no-unescaped-entities */
/* eslint-disable @next/next/no-img-element */
import React from 'react'
import styles from './cardSlider.module.css'

export default function CardSlider() {
  return (
    <div className={styles.cardWrapper}>
      <div
        id="carouselExampleControls"
        className="carousel slide"
        data-bs-interval="false"
        data-bs-pause="false"
      >
        <div className={`carousel-inner ${styles.cardCarousel}`}>
          <div className="carousel-item active">
            <div className="card" style={{ width: 55 + 'rem', height: 25 + 'em' }}>
              <div className="tabbed-photo--area">
                <div className="tab-content row">
                  <div className="photos col col-12 col-sm-6 d-md-block">
                    <img
                      className="img-fluid"
                      alt="Room before"
                      src="https://modsy-prod.imgix.net/mainsite-wp-content/2021/06/Toby-Before-1.jpg?auto=compress%2Cformat&amp;q=25"
                    />
                  </div>
                  <div className="photos col-12 col-sm-6 d-md-block">
                    <img
                      className="img-fluid"
                      alt="Room after"
                      src="https://modsy-prod.imgix.net/mainsite-wp-content/2021/06/Toby-After-1.jpg?auto=compress%2Cformat&amp;q=25"
                    />
                  </div>
                </div>
              </div>

              <div className={`card-body ${styles.title}`}>
                <h5 className="card-title d-flex justify-content-center">Card title</h5>
                <p className="card-text d-flex justify-content-center mt-3">
                  Some quick example text to build on the card title and make up the bulk of the
                  card's content.
                </p>
              </div>
            </div>
          </div>
          <div className="carousel-item">
            <div className="card" style={{ width: 55 + 'rem', height: 25 + 'em' }}>
              <img src="/slider2.png" alt="img1" className=" mt-0 card-img-top" />
              <div className="card-body">
                <h5 className="card-title d-flex justify-content-center">Card title</h5>
                <p className="card-text d-flex justify-content-center mt-3">
                  Some quick example text to build on the card title and make up the bulk of the
                  card's content.
                </p>
              </div>
            </div>
          </div>
          <div className="carousel-item">
            <div className="card" style={{ width: 55 + 'rem', height: 25 + 'em' }}>
              <img src="/slider3.png" alt="img1" className=" mt-0 card-img-top" />
              <div className="card-body">
                <h5 className="card-title d-flex justify-content-center">Card title</h5>
                <p className="card-text d-flex justify-content-center mt-3">
                  Some quick example text to build on the card title and make up the bulk of the
                  card's content.
                </p>
              </div>
            </div>
          </div>
        </div>
        <div className={`${styles.cardControl1}`}>
          <button
            className="carousel-control-prev"
            type="button"
            data-bs-target="#carouselExampleControls"
            data-bs-slide="prev"
          >
            <span
              className={`carousel-control-prev-icon ${styles.prevIcon}`}
              aria-hidden="true"
            ></span>
            <span className="visually-hidden">Previous</span>
          </button>
        </div>
        <div className={`${styles.cardControl2}`}>
          <button
            className="carousel-control-next"
            type="button"
            data-bs-target="#carouselExampleControls"
            data-bs-slide="next"
          >
            <span
              className={`carousel-control-prev-icon ${styles.nextIcon}`}
              aria-hidden="true"
            ></span>
            <span className="visually-hidden">Next</span>
          </button>
        </div>
      </div>
      <button type="button" className={`btn btn-outline mx-2 ${styles.btnCustomOutlinePrimary}`}>
        Browse all ideas
      </button>
    </div>
  )
}
