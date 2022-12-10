function Y = fn_StatsSmoother(x,y)
  z=y;
  position =1;
  max = length(x);
  while position <= max
    up1 = 0;
    up2 = 0;
    down1 = 0;
    down2 = 0;
    if position-1 > 0
      if position+1 < max
        up1 = y(position+1);
        down1 = y(position-1);
        if position-2 > 0
          if position+2 < max
            up2 = y(position+2);
            down2= (position-2);
            sum = up1 + up2 + down1 + down2 + y(position);
            avg = sum/5;
            z(position)=avg;
          endif
        endif
      else
        sum = up1 + down1 + y(position);
        avg = sum/3;
        z(position)=avg;
      endif
    else
      z(position) = y(position);
    endif
    position=position+1;
  endwhile
  plot (x,z)
  grid on
  title('Smoothed Graph of Salted Data')
  xlabel('X')
  ylabel('Y')
  set(gca, 'FontSize', 24)
  Y=z
end
