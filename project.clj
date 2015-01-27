(def clojure     "1.6.0")

(def http-kit    "2.1.19")
(def compojure   "1.3.1")
(def ring        "1.3.2")
(def cheshire    "5.4.0")
(def timbre      "3.3.1")

(def servlet-api "2.5")
(def ancient     "0.6.1")
(def cider       "0.8.2")


(defproject skelet "0.1.0-SNAPSHOT"
  :description "Skelet - backend for Vita"

  :global-vars {*warn-on-reflection* true}

  :main vita.handler

  :dependencies [[org.clojure/clojure ~clojure]

                 ;; server, routes
                 [http-kit ~http-kit]
                 [compojure ~compojure
                  :exclusions [commons-codec]]
                 [ring/ring-core ~ring
                  :exclusions [org.clojure/tools.reader]]

                 ;; serialization/deserialization
                 [cheshire ~cheshire]

                 ;; logging
                 [com.taoensso/timbre ~timbre]]

  :exclusions [org.clojure/clojure]

  :plugins [[lein-ancient ~ancient :exclusions [org.clojure/clojure]]]

  :profiles {:dev
             {:dependencies
              [[ring/ring-devel ~ring]
               [cider/cider-nrepl ~cider
                :exclusions [org.clojure/java.classpath]]
               [javax.servlet/servlet-api ~servlet-api]]}})
