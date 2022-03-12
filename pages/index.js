import Topbar from '../components/topbar'
import Layout from '../components/layout'
import Footer from '../components/footer'
import Carousel from '../components/carousel'
import SmallCarousel from '../components/smallCarousel'
import CardSlider from '../components/cardSlider'
import Toprecommend from '../components/toprecommend'
import Designstyle from '../components/designstyle'
import Loveit from '../components/loveit'

export default function Index() {
  return <h1>This is Home Page</h1>
}

Index.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      <Carousel />
      <Toprecommend />  
      <CardSlider />
      <Designstyle />
      <Loveit />
      <SmallCarousel />
      <Footer />
    </Layout>
  )
}
