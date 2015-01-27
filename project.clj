(defproject vita "0.1.0-SNAPSHOT"
  :description "Vita UI"
  :global-vars {*warn-on-reflection* true}

  :dependencies [[org.clojure/clojure "1.6.0"]

                 ;; server, routes
                 [http-kit "2.1.19"]
                 [compojure "1.3.1"
                  :exclusions [commons-codec]]
                 [ring/ring-core "1.3.2"
                  :exclusions [org.clojure/tools.reader]]

                 ;; serialization/deserialization
                 [cheshire "5.4.0"]

                 ;; logging
                 [com.taoensso/timbre "3.3.1"
                  :exclusions [org.clojure/tools.reader]]]

  :exclusions [org.clojure/clojure]

  :plugins [[lein-ancient   "0.6.1" :exclusions [org.clojure/clojure]]]

  :profiles {:dev
             {:dependencies [[ring/ring-devel "1.3.2"]
                             [cider/cider-nrepl "0.8.2"
                              :exclusions [org.clojure/java.classpath]]
                             [javax.servlet/servlet-api "2.5"]]}}

  :main vita.handler)
