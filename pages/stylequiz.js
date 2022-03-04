/* eslint-disable @next/next/link-passhref */
/* eslint-disable @next/next/no-img-element */
import Layout from "../components/layout";
import Topbar from "../components/topbar";
import Footer from "../components/footer";
import styles from "../styles/StyleQuiz.module.css";
import SmallCarousel from "../components/smallCarousel";
import TakeTheQuiz from "../components/takeTheQuiz";
import Link from "next/link";

export default function StyleQuiz() {
  return (
    <div className="styleQuizWrapper">
      <section
        className="d-lg-flex py-0 full-half-width-block three-up-content "
        id="block_60022a56a11a8"
      >
        <div className={`row align-items-center ${styles.rowCustome}`}>
          <div className={"col-12 col-sm-6 text-center text-center color"}>
            <div className="row">
              <div className={`content ${styles.contentCustome}`}>
                <div className={`${styles.contentWidth}`}>
                  <div
                    className={`d-flex flex-column justify-content-center align-items-start ${styles.content}`}
                  >
                    <h1 className={`${styles.title}`}>
                      What Is My Interior Design Style?
                      <br />
                    </h1>
                    <p>
                      Need help identifying your personal design style? With all
                      the inspiration out there, uncovering your style can be
                      overwhelming. Enter: the Sparkle interior design style
                      quiz. Our fast, free style quiz will help you pinpoint
                      your interior design style, all in a few minutes or less.
                    </p>
                    <p>
                      <Link href="/takestylequiz">
                        <button
                          type="button"
                          className={`btn ${styles.btnCustom} `}
                          style={{ marginTop: 0.5 + "em" }}
                        >
                          Take The Quiz
                        </button>
                      </Link>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div
            className={`col-6 col-sm-6 text-center text-center aligned-right ${styles.mainGraphic}`}
          >
            <img src="/maingraphic.png" alt="StyleQuiz img" />
          </div>
        </div>
      </section>
      <div
        style={{ height: 35 + "px" }}
        aria-hidden="true"
        className={`wp-block-spacer ${styles.wpBlockSpacer}`}
      ></div>
      <section className={styles.quizSection}>
        <div className="container">
          <div className="row d-flex flex-row justify-content-center align-items-center flex-wrap ">
            <div className={`col-6  ${styles.imgLeft} mx-4 my-4`}>
              <img src="/stylequizbody.png" alt="Main Graphic" />
            </div>

            <div className={`col-6 ${styles.contentRight}`}>
              <h2>
                Our Approach:
                <br />
                One Style Doesn’t Fit All
              </h2>
              <p>
                At Sparkle, we believe personal style is incredibly nuanced—so
                we took a very nuanced approach when developing our home style
                quiz. Rather than label you with a single design style, we
                introduce you to a unique, blended result that’s incredibly
                personal. You’re not just stuck with a style like “rustic” or
                “minimalist,” because most people prefer a look that’s a blend
                of several different interior design styles. Your quiz results
                will reflect your nuanced, personal preferences and give you the
                tools to bring your style to life in your real space.{" "}
              </p>
            </div>
          </div>
        </div>
      </section>
      <div
        style={{ height: 35 + "px" }}
        aria-hidden="true"
        className={`wp-block-spacer ${styles.wpBlockSpacer}`}
      ></div>
    </div>
  );
}

StyleQuiz.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <SmallCarousel />
      <TakeTheQuiz />
      <Footer />
    </Layout>
  );
};
