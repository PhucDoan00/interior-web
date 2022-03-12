import Footer from '../../components/footer'
import Layout from '../../components/layout'
import Topbar from '../../components/topbar'

export default function Nursey() {
  return (
    <div>
      <h1>This is Nursey page</h1>
    </div>
  )
}

Nursey.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <Footer />
    </Layout>
  )
}
