(ns substream.core
  (:import substream.FnInputStream))

(defprotocol ToOctet
  (to-octet [x]))

(extend-protocol ToOctet
  Integer
  (to-octet [x] x)
  Long
  (to-octet [x] (Integer/valueOf x))
  Byte
  (to-octet [x] (Integer/valueOf (bit-and x 0xff)))
  nil
  (to-octet [_] (Integer/valueOf -1)))

(defn input-stream
  "Create a java.io.InputStream from a zero-argument function that returns
  the next byte in the stream."
  [func]
  (FnInputStream. (comp to-octet func)))
