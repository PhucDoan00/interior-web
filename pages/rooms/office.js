import Footer from '../../components/footer'
import Layout from '../../components/layout'
import Topbar from '../../components/topbar'

export default function Office() {
  return (
    <div>
      <h1>This is Office page</h1>
    </div>
  )
}

Office.getLayout = function getLayout(page) {
  return (
    <Layout>
      <Topbar />
      {page}
      <Footer />
    </Layout>
  )
}
