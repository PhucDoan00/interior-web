import styles from "./takeTheQuiz.module.css";

export default function TakeTheQuiz() {
  return (
    <div className={`d-flex flex-column justify-content-center align-items-center ${styles.btnTakeQuiz}`}>
      <h2 className={`mb-4 ${styles.title}`}> Ready to get started? </h2>
      <button
        type="button"
        className={`btn ${styles.btnCustom} ${styles.title} `}
        style={{ marginTop: 0.5 + "em" }}
      >
        Take The Quiz
      </button>
    </div>
  );
}
