import java.io.*;
import java.util.Arrays;
public class nearestDecode
{
	//this method gives the config for a fixed set of values,
    //since this is the best LUT so far.
    public static int quantize(int sample)
    {
        int[] mvols = new int[]{7, 6, 7, 6, 7, 5, 6, 7, 5, 6, 4, 5, 6, 4, 5, 7, 4, 6, 5, 4, 2, 7, 6, 5, 4, 3, 2, 1, 0, 0};
        int[] pulsel = new int[]{0, 0, 1, 1, 2, 1, 2, 3, 2, 3, 2, 3, 4, 3, 4, 5, 4, 5, 5, 5, 4, 6, 6, 6, 6, 6, 6, 6, 6, 7};
        int[] pulseh = new int[]{15, 15, 14, 14, 13, 14, 13, 12, 13, 12, 13, 12, 11, 12, 11, 10, 11, 10, 10, 10, 11, 9, 9, 9, 9, 9, 9, 9, 9, 8};
        //int[] outarray = new int[2];
        int config = 0;
        int label = 0;
        if((sample>=0 || sample<0) && sample<15)
        {
            config = (pulsel[0]<<4)|mvols[0];
            label =0;
        }
        if(sample>=15 && sample<18)
        {
            config = (pulsel[1]<<4)|mvols[1];
            label =1;
        }
        if(sample>=18 && sample<31)
        {
            config = (pulsel[2]<<4)|mvols[2];
            label =2;
        }
        if(sample>=31 && sample<36)
        {
            config = (pulsel[3]<<4)|mvols[3];
            label =3;
        }
        if(sample>=36 && sample<45)
        {
            config = (pulsel[4]<<4)|mvols[4];
            label =4;
        }
        if(sample>=45 && sample<47)
        {
            config = (pulsel[5]<<4)|mvols[5];
            label =5;
        }
        if(sample>=47 && sample<54)
        {
            config = (pulsel[6]<<4)|mvols[6];
            label =6;
        }
        if(sample>=54 && sample<58)
        {
            config = (pulsel[7]<<4)|mvols[7];
            label =7;
        }
        if(sample>=58 && sample<63)
        {
            config = (pulsel[8]<<4)|mvols[8];
            label =8;
        }
        if(sample>=63 && sample<70)
        {
            config = (pulsel[9]<<4)|mvols[9];
            label =9;
        }
        if(sample>=70 && sample<72)
        {
            config = (pulsel[10]<<4)|mvols[10];
            label =10;
        }
        if(sample>=72 && sample<79)
        {
            config = (pulsel[11]<<4)|mvols[11];
            label =11;
        }
        if(sample>=79 && sample<81)
        {
            config = (pulsel[12]<<4)|mvols[12];
            label =12;
        }
        if(sample>=81 && sample<86)
        {
            config = (pulsel[13]<<4)|mvols[13];
            label =13;
        }
        if(sample>=86 && sample<90)
        {
            config = (pulsel[14]<<4)|mvols[14];
            label =14;
        }
        if(sample>=90 && sample<92)
        {
            config = (pulsel[15]<<4)|mvols[15];
            label =15;
        }
        if(sample>=92 && sample<95)
        {
            config = (pulsel[16]<<4)|mvols[16];
            label =16;
        }
        if(sample>=95 && sample<99)
        {
            config = (pulsel[17]<<4)|mvols[17];
            label =17;
        }
        if(sample>=99 && sample<104)
        {
            config = (pulsel[18]<<4)|mvols[18];
            label =18;
        }
        if(sample>=104 && sample<106)
        {
            config = (pulsel[19]<<4)|mvols[19];
            label =19;
        }
        if(sample>=106 && sample<108)
        {
            config = (pulsel[20]<<4)|mvols[20];
            label =20;
        }
        if(sample>=108 && sample<111)
        {
            config = (pulsel[21]<<4)|mvols[21];
            label =21;
        }
        if(sample>=111 && sample<113)
        {
            config = (pulsel[22]<<4)|mvols[22];
            label =22;
        }
        if(sample>=113 && sample<115)
        {
            config = (pulsel[23]<<4)|mvols[23];
            label =23;
        }
        if(sample>=115 && sample<117)
        {
            config = (pulsel[24]<<4)|mvols[24];
            label =24;
        }
        if(sample>=117 && sample<120)
        {
            config = (pulsel[25]<<4)|mvols[25];
            label =25;
        }
        if(sample>=120 && sample<122)
        {
            config = (pulsel[26]<<4)|mvols[26];
            label =26;
        }
        if(sample>=122 && sample<124)
        {
            config = (pulsel[27]<<4)|mvols[27];
            label =27;
        }
        if(sample>=124 && sample<127)
        {
            config = (pulsel[28]<<4)|mvols[28];
            label =28;
        }
        if(sample==127)
        {
            config = (pulsel[29]<<4)|mvols[29];
            label =29;
        }
        
        if(sample==128)
        {
            config = (pulseh[29]<<4)|mvols[29];
            label =30;
        }
        if(sample>128 && sample<=130)
        {
            config = (pulseh[28]<<4)|mvols[28];
            label =31;
        }
        if(sample>130 && sample<=132)
        {
            config = (pulseh[27]<<4)|mvols[27];
            label =32;
        }
        if(sample>132 && sample<=134)
        {
            config = (pulseh[26]<<4)|mvols[26];
            label =33;
        }
        if(sample>134 && sample<=137)
        {
            config = (pulseh[25]<<4)|mvols[25];
            label =34;
        }
        if(sample>137 && sample<=139)
        {
            config = (pulseh[24]<<4)|mvols[24];
            label =35;
        }
        if(sample>139 && sample<=141)
        {
            config = (pulseh[23]<<4)|mvols[23];
            label =36;
        }
        if(sample>141 && sample<=143)
        {
            config = (pulseh[22]<<4)|mvols[22];
            label =37;
        }
        if(sample>143 && sample<=146)
        {
            config = (pulseh[21]<<4)|mvols[21];
            label =38;
        }
        if(sample>146 && sample<=148)
        {
            config = (pulseh[20]<<4)|mvols[20];
            label =39;
        }
        if(sample>148 && sample<=150)
        {
            config = (pulseh[19]<<4)|mvols[19];
            label =40;
        }
        if(sample>150 && sample<=155)
        {
            config = (pulseh[18]<<4)|mvols[18];
            label =41;
        }
        if(sample>155 && sample<=159)
        {
            config = (pulseh[17]<<4)|mvols[17];
            label =42;
        }
        if(sample>159 && sample<=162)
        {
            config = (pulseh[16]<<4)|mvols[16];
            label =43;
        }
        if(sample>162 && sample<=164)
        {
            config = (pulseh[15]<<4)|mvols[15];
            label =44;
        }
        if(sample>164 && sample<=168)
        {
            config = (pulseh[14]<<4)|mvols[14];
            label =45;
        }
        if(sample>168 && sample<=173)
        {
            config = (pulseh[13]<<4)|mvols[13];
            label =46;
        }
        if(sample>173 && sample<=175)
        {
            config = (pulseh[12]<<4)|mvols[12];
            label =47;
        }
        if(sample>175 && sample<=182)
        {
            config = (pulseh[11]<<4)|mvols[11];
            label =48;
        }
        if(sample>182 && sample<=184)
        {
            config = (pulseh[10]<<4)|mvols[10];
            label =49;
        }
        if(sample>184 && sample<=191)
        {
            config = (pulseh[9]<<4)|mvols[9];
            label =50;
        }
        if(sample>191 && sample<=196)
        {
            config = (pulseh[8]<<4)|mvols[8];
            label =51;
        }
        if(sample>196 && sample<=200)
        {
            config = (pulseh[7]<<4)|mvols[7];
            label =52;
        }
        if(sample>200 && sample<=207)
        {
            config = (pulseh[6]<<4)|mvols[6];
            label =53;
        }
        if(sample>207 && sample<=209)
        {
            config = (pulseh[5]<<4)|mvols[5];
            label =54;
        }
        if(sample>209 && sample<=218)
        {
            config = (pulseh[4]<<4)|mvols[4];
            label =55;
        }
        if(sample>218 && sample<=223)
        {
            config = (pulseh[3]<<4)|mvols[3];
            label =56;
        }
        if(sample>223 && sample<=236)
        {
            config = (pulseh[2]<<4)|mvols[2];
            label =57;
        }
        if(sample>236 && sample<=239)
        {
            config = (pulseh[1]<<4)|mvols[1];
            label =58;
        }
        if(sample>239)
        {
            config = (pulseh[0]<<4)|mvols[0];
            label =59;
        }
        //outarray[0]=config;
        //outarray[1]=label;
        return config;
    }
    //this first check method checks to see if the target config is high priority
    //(no problems with triggering pulse first)
    public static boolean check1(int lastconfig, int thisconfig)
    {
        int lastpulse = lastconfig>>4;
        int thispulse = thisconfig>>4;
        int lastvol = lastconfig&7;
        int thisvol = thisconfig&7;
        if((lastpulse==thispulse)||(lastvol==thisvol))
        {
            return true;
        }
        if((thispulse>7)&&(lastpulse>7)&&(thispulse>lastpulse)&&(thisvol>lastvol))
        {
            return true;
        }
        if((thispulse<8)&&(lastpulse<8)&&(thispulse<lastpulse)&&(thisvol>lastvol))
        {
            return true;
        }
        if((thispulse>7)&&(lastpulse>7)&&(thispulse<lastpulse)&&(thisvol<lastvol))
        {
            return true;
        }
        if((thispulse<8)&&(lastpulse<8)&&(thispulse>lastpulse)&&(thisvol<lastvol))
        {
            return true;
        }
        if((thispulse>7)&&(lastpulse<8)&&(thisvol>lastvol))
        {
            return true;
        }
        if((thispulse<8)&&(lastpulse>7)&&(thisvol>lastvol))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //this second check method evaluates the best option
    //for when pulse and master volume are moving in different
    //directions.
    //return 0 or 2 is for use pulse first, 1 or 3 is for vol first,
    //and >=2 is for enabling a warning.
    public static int check2(int lastconfig, int thisconfig) 
    {
        int lastpulse = lastconfig>>4;
        int thispulse = thisconfig>>4;
        int lastvol = lastconfig&7;
        int thisvol = thisconfig&7;
        int prevtemp = 0; //load master volume first
        int currtemp = 0; //trigger pulse first
        int prev8bit = 0;
        int curr8bit = 0;
        if(thispulse<8)
        {
            currtemp = -(7-thispulse);
            curr8bit = (int)(127+(127*((currtemp/7)*((thisvol+1)/8))));
            currtemp = (int)(127+(127*((currtemp/7)*((lastvol+1)/8))));
        }
        if(thispulse>7)
        {
            currtemp = thispulse-8;
            curr8bit = (int)(128+(127*((currtemp/7)*((thisvol+1)/8))));
            currtemp = (int)(128+(127*((currtemp/7)*((lastvol+1)/8))));  
        }
        if(lastpulse<8)
        {
            prevtemp = -(7-lastpulse);
            prev8bit = (int)(127+(127*((prevtemp/7)*((lastvol+1)/8))));
            prevtemp = (int)(127+(127*((prevtemp/7)*((thisvol+1)/8))));
        }
        if(lastpulse>7)
        {
            prevtemp = lastpulse-8;
            prev8bit = (int)(128+(127*((prevtemp/7)*((lastvol+1)/8))));
            prevtemp = (int)(128+(127*((prevtemp/7)*((thisvol+1)/8))));
        }
        if(curr8bit>prev8bit) //part 1 of failsafe 
        {
            if((currtemp<=curr8bit)&&(currtemp>=prev8bit))
            {
                return 0;
            }
            if((prevtemp<=curr8bit)&&(prevtemp>=prev8bit))
            {
                return 1;
            }
            if(currtemp>curr8bit)
            {
                if(prevtemp>curr8bit)
                {
                    if(currtemp<prevtemp)
                    {
                        if(currtemp<=curr8bit+16)
                        {
                            return 0;
                        }
                        else
                        {
                            return 2;
                        }
                    }
                    else
                    {
                        if(prevtemp<=curr8bit+16)
                        {
                            return 1;
                        }
                        else
                        {
                            return 3;
                        }
                    }
                }
                else
                {
                    return 1;
                }
            }
            if(currtemp<prev8bit)
            {
                if(prevtemp<prev8bit)
                {
                    if(currtemp>prevtemp)
                    {
                        if(currtemp>=prev8bit-16)
                        {
                            return 0;
                        }
                        else
                        {
                            return 2;
                        }
                    }
                    else
                    {
                        if(prevtemp>=prev8bit-16)
                        {
                            return 1;
                        }
                        else
                        {
                            return 3;
                        }
                    }
                }
                else
                {
                    return 1;
                }
            }
        }
        else //part 2 of failsafe, like part 1 but prev/curr8bit are reversed
        {
            if((currtemp<=prev8bit)&&(currtemp>=curr8bit))
            {
                return 0;
            }
            if((prevtemp<=prev8bit)&&(prevtemp>=curr8bit))
            {
                return 1;
            }
            if(currtemp>prev8bit)
            {
                if(prevtemp>prev8bit)
                {
                    if(currtemp<prevtemp)
                    {
                        if(currtemp<=prev8bit+16)
                        {
                            return 0;
                        }
                        else
                        {
                            return 2;
                        }
                    }
                    else
                    {
                        if(prevtemp<=prev8bit+16)
                        {
                            return 1;
                        }
                        else
                        {
                            return 3;
                        }
                    }
                }
                else
                {
                    return 1;
                }
            }
            if(currtemp<curr8bit)
            {
                if(prevtemp<curr8bit)
                {
                    if(currtemp>prevtemp)
                    {
                        if(currtemp>=curr8bit-16)
                        {
                            return 0;
                        }
                        else
                        {
                            return 2;
                        }
                    }
                    else
                    {
                        if(prevtemp>=curr8bit-16)
                        {
                            return 1;
                        }
                        else
                        {
                            return 3;
                        }
                    }
                }
                else
                {
                    return 1;
                }
            }
        }
        return 0;
    }
	public static void main(String[] args)
	{
        if(args.length<2)
        {
            System.out.println("Please provide an input and output file.");
        }
        String inputFile = args[0];
        String outputFile = args[1];
        try
        {
            InputStream fis = new FileInputStream(inputFile);
            OutputStream fos = new FileOutputStream(outputFile);
            int currsamp = 0;
            boolean enablewarning=true;
            int currconfig;
            int prevconfig;
            currsamp = fis.read();
            prevconfig = quantize(currsamp);
            fos.write(prevconfig);
            while((currsamp = fis.read()) != -1)
            {
                currconfig = quantize(currsamp);
                if(check1(prevconfig, currconfig)==false)
                {
                    if((check2(prevconfig, currconfig)==0)||(check2(prevconfig, currconfig)==2))
                    {
                        fos.write(currconfig);
                    }
                    if((check2(prevconfig, currconfig)==1)||(check2(prevconfig, currconfig)==3))
                    {
                        fos.write(currconfig|8);
                    }
                    if((check2(prevconfig, currconfig)>=2)&&(enablewarning==true))
                    {
                        System.out.println("Yikes! The audio's probably still gonna pop a lot.");
                        enablewarning=false;
                    }
                }
                else
                {
                    fos.write(currconfig);
                }
                prevconfig=currconfig;
            }
        }catch(IOException ex)
        {
            ex.printStackTrace();
        }
	}
}