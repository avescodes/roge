#!/usr/bin/env boot

#tailrecursion.boot.core/version "2.2.1"

(set-env!
  :project      'rojue
  :version      "0.1.0-SNAPSHOT"
  :dependencies '[[tailrecursion/boot.task   "2.1.1"]
                  [tailrecursion/hoplon      "5.5.1"]
                  [org.clojure/clojurescript "0.0-2156"]
                  [org.clojure/core.async "0.1.278.0-76b25b-alpha"]]
  :out-path     "resources/public"
  :src-paths    #{"src"})

;; Static resources (css, images, etc.):
(add-sync! (get-env :out-path) #{"assets"})

(require '[tailrecursion.hoplon.boot :refer :all])

(deftask development
  "Build rojue for development."
  []
  (comp (watch) (hoplon {:prerender false :pretty-print true})))

(deftask production
  "Build rojue for production."
  []
  (hoplon {:optimizations :advanced}))
