import Layout from '../../components/layout'
import Topbar from '../../components/topbar'
import Footer from '../../components/footer'
import styles from '../../styles/Home.module.css'
import ProductDetail from '../../components/shop/ProductDetail'

const ShopDetail = () => {
  return (
    <Layout>
      <Topbar />
      <ProductDetail />
      <Footer />
    </Layout>
  )
}

export default ShopDetail
