(defproject dbexec "0.1.0-SNAPSHOT"
  :description "Trying to create a simple tool to be able to execute SQL commandsvia JDBC. 
Mainly towork with other tools like notepad++"
  :url "http://vanis.org/dbexec"
  :license {:name "GPL"
            :url "https://www.gnu.org/licenses/gpl-3.0.en.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/java.jdbc "0.6.1"]
                 ]
  :main ^:skip-aot dbexec.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
