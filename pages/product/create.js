import Layout from '../../components/layout'
import Topbar from '../../components/topbar'
import Footer from '../../components/footer'
import CreateProduct from '../../components/product/CreateProduct'

export default function Create() {
  return (
    <Layout>
      <Topbar />
      <CreateProduct />
      <Footer />
    </Layout>
  )
}
