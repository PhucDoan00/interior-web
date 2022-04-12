/* eslint-disable @next/next/link-passhref */
/* eslint-disable @next/next/no-img-element */
import React, { useState } from "react";
import Layout from "../components/layout";
import styles from "../styles/TakeStyleQuiz.module.css";
import Topbar from "../components/topbar";
import Link from "next/link";
import StyleQuizCard from "../components/stylequizcard";

export default function TakeStyleQuiz() {
  const [opacity1, setOpacity1] = useState(1);
  const [opacity2, setOpacity2] = useState(1);
  const [opacity3, setOpacity3] = useState(1);
  const [opacity4, setOpacity4] = useState(1);
  const [opacity5, setOpacity5] = useState(1);
  const [opacity6, setOpacity6] = useState(1);
  const [count, setCount] = useState(0);
  const [isDisabled, setDisabled] = useState(true);

  const rooms = [
    {
      id: 1,
      style: 'Modern Living Room Ideas',
      img: '/designIdeas/livingroom/6.png',
      selected: true,
    },
    {
      id: 2,
      style: 'Mid-Century Living Room Ideas',
      img: '/designIdeas/livingroom/5.png',
    },
    {
      id: 3,
      style: 'Rustic Living Room Ideas',
      img: '/designIdeas/livingroom/8.png',
    },
    {
      id: 4,
      style: 'Eclectic Living Room Ideas',
      img: '/designIdeas/livingroom/7.png',
    },
    {
      id: 5,
      style: 'Coastal Living Room Ideas',
      img: '/designIdeas/livingroom/4.png',
    },
    {
      id: 6,
      style: 'Industrial Living Room Ideas',
      img: '/designIdeas/livingroom/3.png',
    },
    {
      id: 7,
      style: 'Traditional Living Room Ideas',
      img: '/designIdeas/livingroom/1.png',
    },
    {
      id: 8,
      style: 'Glam Living Room Ideas',
      img: '/designIdeas/livingroom/2.png',
    },
  ]

  function handleClickSubmit(key) {
    switch (key) {
      case 1:
        opacity1 == 0.5 ? setCount(count - 1) : setCount(count + 1);
        break;
      case 2:
        opacity2 == 0.5 ? setCount(count - 1) : setCount(count + 1);
        break;
      case 3:
        opacity3 == 0.5 ? setCount(count - 1) : setCount(count + 1);
        break;
      case 4:
        opacity4 == 0.5 ? setCount(count - 1) : setCount(count + 1);
        break;
      case 5:
        opacity5 == 0.5 ? setCount(count - 1) : setCount(count + 1);
        break;
      case 6:
        opacity6 == 0.5 ? setCount(count - 1) : setCount(count + 1);
        break;

      default:
        break;
    }
  }

  function checkDisabledButtonNext() {
    if (count == 2) {
      setDisabled(false);
    } else {
      setDisabled(true);
    }
  }

  return (
    <div>
      <div className={`${styles.takeStyleQuizWrapper}`}>
        <div className="container justify-content-between align-items-center">
          <div className="col-4 justify-content-between align-items-center position-fixed">
            <h1>Which 3 rooms appeal to you most?</h1>
            <span>Show us what your dream home looks like.</span>
          </div>
          <div className="col-8 offset-sm-6">
            {/* <div className="row">
              <div className="col">
                <button
                  onClick={() => {
                    if (count < 3) {
                      setOpacity1(opacity1 == 0.5 ? 1 : 0.5);
                      handleClickSubmit(1);
                      checkDisabledButtonNext();
                    }
                  }}
                >
                  <img
                    src="/ModernOffice1.jpg"
                    className="d-block w-100"
                    alt="modernoffice1"
                    style={{ opacity: opacity1 }}
                  />
                </button>
              </div>
              <div className="col">
                <button
                  onClick={() => {
                    if (count < 3) {
                      setOpacity2(opacity2 == 0.5 ? 1 : 0.5);
                      handleClickSubmit(2);
                      checkDisabledButtonNext();
                    }
                  }}
                >
                  <img
                    src="/ModernOffice1.jpg"
                    className="d-block w-100"
                    alt="modernoffice1"
                    style={{ opacity: opacity2 }}
                  />
                </button>
              </div>
            </div>
            <div className="row">
              <div className="col">
                <button
                  onClick={() => {
                    if (count < 3) {
                      setOpacity3(opacity3 == 0.5 ? 1 : 0.5);
                      handleClickSubmit(3);
                      checkDisabledButtonNext();
                    }
                  }}
                >
                  <img
                    src="/ModernOffice1.jpg"
                    className="d-block w-100"
                    alt="modernoffice1"
                    style={{ opacity: opacity3 }}
                  />
                </button>
              </div>
              <div className="col">
                <button
                  onClick={() => {
                    if (count < 3) {
                      setOpacity4(opacity4 == 0.5 ? 1 : 0.5);
                      handleClickSubmit(4);
                      checkDisabledButtonNext();
                    }
                  }}
                >
                  <img
                    src="/ModernOffice1.jpg"
                    className="d-block w-100"
                    alt="modernoffice1"
                    style={{ opacity: opacity4 }}
                  />
                </button>
              </div>
            </div>
            <div className="row">
              <div className="col">
                <button
                  onClick={() => {
                    if (count < 3) {
                      setOpacity5(opacity5 == 0.5 ? 1 : 0.5);
                      handleClickSubmit(5);
                      checkDisabledButtonNext();
                    }
                  }}
                >
                  <img
                    src="/ModernOffice1.jpg"
                    className="d-block w-100"
                    alt="modernoffice1"
                    style={{ opacity: opacity5 }}
                  />
                </button>
              </div>
              <div className="col">
                <button
                  onClick={() => {
                    if (count < 3) {
                      setOpacity6(opacity6 == 0.5 ? 1 : 0.5);
                      handleClickSubmit(6);
                      checkDisabledButtonNext();
                    }
                  }}
                >
                  <img
                    src="/ModernOffice1.jpg"
                    className="d-block w-100"
                    alt="modernoffice1"
                    style={{ opacity: opacity6 }}
                  />
                </button>
              </div>
            </div> */}
            <div className="container">
              <div className="row row-cols-3 row-cols-lg-2 g-2 g-lg-3">
                {/* Card */}
                {rooms.map((room, index) => (
                  <StyleQuizCard
                    key={index}
                    style={room.style}
                    img={room.img}
                  />
                ))}
              </div>
            </div>
          </div>
        </div>
      </div>

      <div className={`${styles.bottomBar} row justify-content-center`}>
        <div className="container">
          <div className="row">
            <div className="col-6">
              {/* <input className="btn btn-primary" type="submit" value="Submit" /> */}
              <span>{count}</span>
            </div>
            <div className={` col-6 ${styles.buttonContainer}`}>
              {/* <input className="btn btn-primary" type="submit" value="Submit" /> */}
              <Link href="/stylequizresult">
                <button
                  type="button"
                  className={` btn ${styles.buttonNext}`}
                  disabled={count < 3 ? true : false}
                >
                  {count < 3 ? (
                    <span>{count}/3 Selected</span>
                  ) : (
                    <span>Next</span>
                  )}
                </button>
              </Link>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

TakeStyleQuiz.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
    </Layout>
  );
};
