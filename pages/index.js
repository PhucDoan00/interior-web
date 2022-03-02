import Topbar from '../components/topbar'
import Layout from "../components/layout";
import Footer from '../components/footer';
import Carousel from '../components/carousel';
import CardSlider from '../components/cardSlider';
import SmallCarousel from '../components/smallCarousel';
import CardSliderTest from '../components/cardSliderTest';

export default function Index() {
  return (
    <h1>This is Home Page</h1>
  )
}

Index.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      <Carousel/>
      {/* <CardSlider/> */}
      <CardSliderTest />
      {/* {page} */}
      <SmallCarousel/>
      <Footer />
    </Layout>
  );
};
