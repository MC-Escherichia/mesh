(ns mesh.grid
  (:refer-clojure :exclude [+ - * /])
  (:require [garden.core :refer [css]]
            [garden.units :as u :refer [px pt]]
            [garden.units :refer (px+ px* px- px-div em)]
            [garden.color :as color :refer [hsl rgb]]
            [garden.arithmetic :refer [+ - * /]]
            [garden.stylesheet :refer [at-media]]
            [mesh.mixins :refer [border-box clearfix reset-padding]]))

(defn initialize [clazz gutter]
  "Define a unit within grid with a gutter in px"
  [[clazz :.unit border-box]
   [clazz {:display "block"
           :clear "both"}
    [:.unit {:float "left"
             :width "100%"
             :padding (/ gutter 2)}
     [:&:first-child {:padding-left gutter}]
     [:&:last-child {:padding-right gutter}]]]])

(defn create-nested-units []
  [:.unit
   [:.unit
    [:&:first-child {:padding-left 0}]
    [:&:last-child {:padding-right 0}]]
   [:.grid:first-child
    [:>
     [:.unit {:padding-top 0}]]]
   [:.grid:last-child
    [:>
     [:.unit {:padding-bottom 0}]]]])

(defn nuke-gutters-and-padding []
  [[:.unit.no-gutters reset-padding]
   [:.no-gutters
    [:.unit reset-padding]]])

(defn wrap-widths [width]
  [[:.wrap
    [:.grid {:max-width (px width)
             :margin "0 auto"}]]
   [:.grid.wrap
    {:max-width (px width)
     :margin "0 auto"}]])

(defn create [clazz]
  [[clazz
    [:.whole {:width "100%"}]]
   [clazz
    [:.half {:width "50%"}]]
   [clazz
    [:.one-third {:width "33.3332%"}]]
   [clazz
    [:.two-thirds {:width "66.6665%"}]]
   [clazz
    [:.one-fourth :.one-quarter {:width "25%"}]]
   [clazz
    [:.three-forths :.three-quarters {:width "75%"}]]
   [clazz
    [:.one-fifth {:width "20%"}]]
   [clazz
    [:.two-fifths {:width "40%"}]]
   [clazz
    [:.three-fifths {:width "60%"}]]
   [clazz
    [:.four-fifths {:width "80%"}]]
   [clazz
    [:.golden-small {:width "38.2716%"}]]
   [clazz
    [:.golden-large {:width "61.7283%"}]]])

(defn respond-small [width gutter]
  (at-media {:screen true :max-width width}
            [".grid:not(.no-stacking-on-mobiles)"
             [:>
              [:.unit {:width "100% !important"
                       :padding-left gutter
                       :padding-right gutter}]]]
            [:.unit
             [:.grid
              [:.unit {:padding-left (px 0)
                       :padding-right (px 0)}]]]
            [:.center-on-mobiles {:text-align "center !important"}]
            [:.hide-on-mobiles {:display "none !important"}]))

(defn respond-medium [width]
  (at-media {:screen true :min-width width}
            [:.wider
             [:.grid {:max-width width
                      :margin "0 auto"}]]))