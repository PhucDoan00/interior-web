/* eslint-disable @next/next/no-img-element */
import styles from '../components/smallCarousel.module.css'

export default function SmallCarousel() {
  return (
    <div className="container">
      <div className="row justify-content-around">
        <div className={`col d-flex flex-column justify-content-center ${styles.title}`}>
          <h1 className="my-3"> Turn Your Result Into Reality </h1>
          <p>What are you waiting for? Come to check it out !</p>
        </div>
        <div className="col">
          <div
            id="carouselExampleIndicators"
            className={`carousel slide ${styles.smallCarousel}`}
            data-bs-ride="carousel"
            data-bs-pause="false"
          >
            <div className="carousel-indicators">
              <button
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="0"
                className="active"
                aria-current="true"
                aria-label="Slide 1"
              ></button>
              <button
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="1"
                aria-label="Slide 2"
              ></button>
              <button
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="2"
                aria-label="Slide 3"
              ></button>
              <button
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="3"
                aria-label="Slide 4"
              ></button>
            </div>
            <div className="carousel-inner">
              <div className="carousel-item active" data-bs-interval="2000">
                <img src="/smallCarousel/small1.png" className="d-block w-100" alt="sm1" />
              </div>
              <div className="carousel-item" data-bs-interval="2000">
                <img src="/smallCarousel/small2.png" className="d-block w-100" alt="sm2" />
              </div>
              <div className="carousel-item" data-bs-interval="2000">
                <img src="/smallCarousel/small3.png" className="d-block w-100" alt="sm3" />
              </div>
              <div className="carousel-item" data-bs-interval="2000">
                <img src="/smallCarousel/small4.png" className="d-block w-100" alt="sm4" />
              </div>
            </div>
          </div>
        </div>
      </div>
      <div
        style={{ height: 35 + 'px' }}
        aria-hidden="true"
        className={`wp-block-spacer ${styles.wpBlockSpacer}`}
      ></div>
    </div>
  )
}
