(defproject facjure/mesh "0.2.6"  :description "A responsive grid & typography toolkit, built on Clojurescript"  :url "https://github.com/facjure/mesh"  :license {:name "Eclipse Public License"            :url "http://www.eclipse.org/legal/epl-v10.html"}  :scm {:name "git"        :url "https://github.com/facjure/mesh"}  :min-lein-version "2.5.0"  :jvm-opts ["-Xms768m" "-Xmx768m"]  :global-vars {*warn-on-reflection* false *assert* false}  :dependencies [[org.clojure/clojure "1.6.0"]                 [org.clojure/clojurescript "0.0-2850"]                 [com.gfredericks/cljs-numbers "0.1.2"]                 [garden "1.2.5"]]  :node-dependencies [[autoprefixer "5.1.0"]]  :source-paths ["src/clj" "target/generated-clj" "target/generated-cljs" "target/classes"]  :clean-targets ^{:protect false} ["resources/public/js" "target/classes"]  :cljsbuild {:builds              {:mesh               {:source-paths ["target/generated-cljs"                               "target/generated-clj"]                :compiler {:output-to "resources/public/js/mesh.js"                           :output-dir "resources/public/js/out"                           :main dev.repl                           :asset-path "js/out"                           :optimizations :none                           :cache-analysis true                           :source-map true}}}}  :cljx {:builds         [{:source-paths ["src/cljx"]           :output-path "target/generated-clj"           :rules :clj}          {:source-paths ["src/cljx"]           :output-path "target/generated-cljs"           :rules :cljs}]}  :profiles {:dev             {:dependencies [[figwheel "0.2.6"]                             [figwheel-sidecar "0.2.6"]                             [brutha "0.1.0"]                             [org.omcljs/om "0.8.8"]                             [flupot "0.1.0"]                             [sablono "0.3.4"]]              :source-paths ["examples" "target/generated-clj"]              :cljsbuild {:builds                          {:mesh {:source-paths ["examples" "env/dev"]}}}              :figwheel {:http-server-root "public"                         :server-port 3449                         :nrepl-port 7800                         :css-dirs ["resources/public/css"]                         :open-file-command "emacsclient"}              :garden {:builds                       [{:id "typography"                         :source-paths ["src/clj" "examples"]                         :stylesheet typography.styles/index                         :compiler {:output-to "resources/public/css/typography.css"                                    :pretty-print true}}]}}}  :plugins [[lein-cljsbuild "1.0.5"]            [lein-garden "0.2.5"]            [com.keminglabs/cljx "0.6.0"]            [lein-npm "0.5.0"]            [lein-figwheel "0.2.6"]            [lein-pdo "0.1.1"]            [lein-cljfmt "0.1.7"]]  :aliases {"clean-all"  ["pdo" "clean," "garden" "clean"]            "dev" ["pdo" "cljx" "auto," "garden" "auto," "figwheel"]            "format" ["cljfmt" "check"]})