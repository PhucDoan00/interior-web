/* eslint-disable @next/next/no-img-element */
import Layout from "../components/layout";
import Topbar from "../components/topbar";
import Footer from "../components/footer";
import styles from "../styles/StyleQuiz.module.css";
import Carousel from "../components/carousel";

export default function StyleQuiz() {
  return (
    <div className="styleQuizWrapper">
      <section
        className="d-lg-flex py-0 full-half-width-block three-up-content alignright"
        id="block_60022a56a11a8"
      >
        <div className="row align-items-center">
          <div className={"col-12 col-sm-6 text-center text-center color"}>
            <div className={`row ${styles.rowCustome}`}>
              <div className={`content ${styles.contentCustome}`}>
                <div className={`${styles.contentWidth}`}>
                  <div className="d-flex flex-column justify-content-center align-items-start">
                    <h1 className={`${styles.title}`}>
                      What Is My Interior Design Style?
                      <br />
                    </h1>
                    <p>
                      Need help identifying your personal design style? With all
                      the inspiration out there, uncovering your style can be
                      overwhelming. Enter: the Modsy interior design style quiz.
                      Our fast, free style quiz will help you pinpoint your
                      interior design style, all in a few minutes or less.
                    </p>
                    <p>
                      <a href="https://www.modsy.com/stylequiz/room">
                        <button
                          className="primary cms-page-cta"
                          style={{ marginTop: 0.5 + "em" }}
                        >
                          Take The Quiz
                        </button>
                      </a>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div className={`col-6 col-sm-4 text-center text-center aligned-right ${styles.mainGraphic}`}>
            <img src="/stylequiz2.png" alt="StyleQuiz img" />
          </div>
        </div>
      </section>
    </div>
  );
}

StyleQuiz.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <Footer />
    </Layout>
  );
};
