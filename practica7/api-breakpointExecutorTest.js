import http from "k6/http";
import { check } from "k6";

export const options = {
  scenarios: {
    break_test: {
      executor: "ramping-arrival-rate",
      startRate: 100,
      timeUnit: "1s",
      preAllocatedVUs: 1000,
      maxVUs: 1000000,
      stages: [{ target: 100000, duration: "10m" }],
    },
  },
  thresholds: {
    http_req_failed: [
      {
        threshold: "rate<=0.01", // 1% de fallos
        abortOnFail: true,
      },
    ],
  },
};

export default function () {
  http.get("http://localhost:8080/medico/1");
}
