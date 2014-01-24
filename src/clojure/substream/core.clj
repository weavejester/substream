(ns substream.core)

(defn input-stream
  "Create a java.io.InputStream from a side-effectful function that returns
  the next byte in the stream."
  [f]
  (substream.FnInputStream. f))
