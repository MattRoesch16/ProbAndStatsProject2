function Y = fn_StatsPlotter(x)
  y = ((x.^3 - x.^2 -x)/10);
  plot (x,y)
  grid on
  title('Graph of (x^3 - x^2 - x)/10')
  xlabel('X')
  ylabel('Y')
  set(gca, 'FontSize', 24)
  Y=y;
end
