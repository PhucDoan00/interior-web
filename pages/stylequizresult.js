/* eslint-disable @next/next/link-passhref */
/* eslint-disable @next/next/no-img-element */
import Layout from "../components/layout";
import Topbar from "../components/topbar";
import Footer from "../components/footer";
import styles from "../styles/stylequizresult.module.css"

export default function StyleQuizResult() {
  return (
    <div>
      <div className="ResultContainer">
        <div className="resultSection">
          <p>Your style is</p>
          <span>Mid-Century Chic</span>
          <p>
            Enjoy mid-century flair with a twist. Bright bold pieces matched
            with texture and greenery make the perfect pairing. Color and style
            are always on-trend.{" "}
          </p>
        </div>

        <div className="imgContain">
          <div className="bigImg">
            <div className="firstImg">
              <img src="/Mid-Century-Chic-01.png" alt="Mid-Century-Chic"/>
            </div>
            <div className="twoSmallImg">
              <img src="/Mid-Century-Chic-02.png" alt="Mid-Century-Chic"/>
              <img src="/Mid-Century-Chic-03.png" alt="Mid-Century-Chic"/>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

StyleQuizResult.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <Footer />
    </Layout>
  );
};
