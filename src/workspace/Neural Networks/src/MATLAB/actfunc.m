x = 2:0.5:7;
y = sigmf(x,[1 0]);
poly = polyfit(x,y,3);
y1 = polyval(poly,x);
plot(x,y,'r'); hold on;
plot(x,y1,'b'); hold off;