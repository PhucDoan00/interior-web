/* eslint-disable @next/next/no-img-element */
import styles from './carousel.module.css'

export default function Carousel() {
  return (
    <div id="carouselExampleIndicators" className="carousel slide" data-bs-ride="carousel">
      <div className={`carousel-indicators ${styles.carouselDotIndicators}`}>
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
        <button
          type="button"
          data-bs-target="#carouselExampleIndicators"
          data-bs-slide-to="4"
          aria-label="Slide 5"
        ></button>
      </div>
      <div className={`carousel-inner ${styles.carouselWrapper}`}>
        <div className="carousel-item active" data-bs-interval="2000">
          <img src="/bigCarousel/1.png" className="d-block w-100" alt="img 1" />
        </div>
        <div className="carousel-item" data-bs-interval="2000">
          <img src="/bigCarousel/2.png" className="d-block w-100" alt="img 2" />
        </div>
        <div className="carousel-item" data-bs-interval="2000">
          <img src="/bigCarousel/3.png" className="d-block w-100" alt="img 3" />
        </div>
        <div className="carousel-item" data-bs-interval="2000">
          <img src="/bigCarousel/4.png" className="d-block w-100" alt="img 4" />
        </div>
        <div className="carousel-item" data-bs-interval="2000">
          <img src="/bigCarousel/5.png" className="d-block w-100" alt="img 5" />
        </div>
      </div>
      <button
        className="carousel-control-prev"
        type="button"
        data-bs-target="#carouselExampleIndicators"
        data-bs-slide="prev"
      >
        <span className="carousel-control-prev-icon" aria-hidden="true"></span>
        <span className="visually-hidden">Previous</span>
      </button>
      <button
        className="carousel-control-next"
        type="button"
        data-bs-target="#carouselExampleIndicators"
        data-bs-slide="next"
      >
        <span className="carousel-control-next-icon" aria-hidden="true"></span>
        <span className="visually-hidden">Next</span>
      </button>
    </div>
  )
}
