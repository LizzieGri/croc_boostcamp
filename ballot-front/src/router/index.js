import { createWebHistory, createRouter } from "vue-router";
import home from "@/views/home.vue";
import form from "@/views/form.vue";
import diagrams from "@/views/diagrams.vue";
import results from "@/views/results.vue";
import form_results from "@/views/form_results.vue";

const routes = [
      {
        path: "",
        name: "home",
        component: home,
      },
      {
        path: "/form",
        name: "form",
        component: form,
      },
      {
        path: "/diagrams",
        name: "diagrams",
        component: diagrams,
      },
      {
        path: "/results",
        name: "results",
        component: results,
      },
      {
        path: "/form-results",
        name: "form_results",
        component: form_results,
      }
    ];
    
    const router = createRouter({
      history: createWebHistory(),
      routes,
    });
    
    export default router;