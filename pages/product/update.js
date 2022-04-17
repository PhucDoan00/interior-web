import Layout from '../../components/layout'
import Topbar from '../../components/topbar'
import Footer from '../../components/footer'
// import CreateProduct from '../../components/product/CreateProduct'
import UpdateProduct from '../../components/product/UpdatedProduct'
export default function Update() {
  return (
    <Layout>
      <Topbar />
      <UpdateProduct />
      <Footer />
    </Layout>
  )
}
