import { defineConfig } from "cypress";

export default defineConfig({
  e2e: {
    baseUrl: "http://localhost:5173",
    env: {
      VITE_BACKEND_SERVER: "http://localhost:3000"
    },
    setupNodeEvents(on, config) {

    }
  },
});
