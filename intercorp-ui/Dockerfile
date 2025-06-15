# Etapa 1: construir Angular
FROM node:20 as build
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build -- --configuration=production

# Etapa 2: servir con Nginx
FROM nginx:alpine
COPY --from=build /app/dist/intercorp-ui/browser /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
