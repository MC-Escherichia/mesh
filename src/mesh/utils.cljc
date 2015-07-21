(ns mesh.utils
  (:require [garden.core :refer [css]]))

#+clj
(defn pow [base e]
  (.pow Math base e))

#+cljs
(defn pow [base e]
  (.pow js/Math base e))

#+cljs
(defn viewport-w []
  (.. js/document -documentElement -clientWidth))

#+cljs
(defn viewport-h []
  (.. js/document -documentElement -clientHeight))

(def reset-padding
  {:padding "0 !important"})

(def border-box
  {:box-sizing "border-box"})

(defn clearfix [clazz]
  [clazz {:*zoom 1}
   [:&:before :&:after {:display "table"
                        :content " "
                        :line-height 0}]
   [:&:after {:clear "both"}]])

(def alignments
  [[:.align-center {:text-align "center"}]
   [:.align-left {:text-align "left"}]
   [:.align-right {:text-align "right"}]
   [:.pull-left {:float "left"}]
   [:.pull-right {:float "right"}]])

(def reset-common-selectors
  [:h1 :h2 :h3 :h4 :h5 :h6
   :p :blockquote :pre
   :dl :dt :dd :ol :ul :li
   :fieldset :form :label :legend
   :th :td
   :artcle :section :aside :figure :footer :header
   :hgroup :menu :nav :section
   {:margin 0
    :padding 0
    :border 0}])

(defn whole-number? [n]
  (= n (Math/floor n)))