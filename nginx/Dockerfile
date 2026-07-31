#-----------nginx stage----------
# Remove the default NGINX page
RUN rm -rf /usr/share/nginx/html/*

# Copy your website
COPY nginx/index.html /usr/share/nginx/html/

# Expose HTTP port
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]