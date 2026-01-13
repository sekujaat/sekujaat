import axios from "axios";
import { secureStorage } from "./storage/secureStorage";

const api = axios.create({
  baseURL: "https://agora-node-tokenserver-1.onrender.com", // Synce backend URL
});

export async function loginApi(email, password) {
  const res = await api.post("/auth/login", { email, password });
  const { token, user } = res.data;
  await secureStorage.set("auth_token", token);
  return user;
}

export async function signupApi(payload) {
  const res = await api.post("/auth/signup", payload);
  const { token, user } = res.data;
  await secureStorage.set("auth_token", token);
  return user;
}

export async function getCurrentUser() {
  const token = await secureStorage.get("auth_token");
  if (!token) return null;
  const res = await api.get("/auth/me", {
    headers: { Authorization: `Bearer ${token}` },
  });
  return res.data.user;
}

export async function logoutApi() {
  await secureStorage.remove("auth_token");
}
