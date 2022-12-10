function Y = fn_StatsSalter(x,maxchange)
  a=maxchange*rand(1,length(x))
  z=x-a
  plot (x,z)
  grid on
  title('Salted Graph of y=x')
  xlabel('X')
  ylabel('Y')
  set(gca, 'FontSize', 24)
  Y=z;
end
