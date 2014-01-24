# Substream

[![Build Status](https://travis-ci.org/weavejester/substream.png?branch=master)](https://travis-ci.org/weavejester/substream)

Substream is a small library for constructing subclasses of
`java.io.InputStream` from standard Clojure functions.

This is necessary due to the limitations of
[subclassing in clojure][1].

[1]: http://tech.puredanger.com/2011/08/12/subclassing-in-clojure/

## Installation

To install, add the following to your project `:dependencies`:

    [substream "0.1.0-SNAPSHOT"]

## Usage

The `substream.core/input-stream` function will construct a new
InputStream instance from a zero-argument Clojure function. The
function can returns a value representing a byte from the stream. The
return value may be an integer, byte or nil if the stream has ended.

```clojure
(require '[substream.core :as substream])

(def data
  (ref (seq (.getBytes "Hello World"))))

(def stream
  (substream/input-stream
   #(dosync
      (when (seq @state)
        (let [value (first @state)]
          (alter state next)
          value))))
```

## License

Copyright © 2014 James Reeves

Distributed under the MIT License.
