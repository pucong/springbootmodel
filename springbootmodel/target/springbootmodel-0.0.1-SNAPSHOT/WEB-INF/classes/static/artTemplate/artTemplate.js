/*!art-template - Template Engine | http://aui.github.com/artTemplate/*/

!function(){function e(e){return e.replace(y,"").replace(b,",").replace(w,"").replace(x,"").replace(j,"").split(/^$|,+/)}function n(e){return"'"+e.replace(/('|\\)/g,"\\$1").replace(/\r/g,"\\r").replace(/\n/g,"\\n")+"'"}function t(t,r){function a(e){return p+=e.split(/\n/).length-1,u&&(e=e.replace(/[\n\r\t\s]+/g," ").replace(/<!--.*?-->/g,"")),e&&(e=v[1]+n(e)+v[2]+"\n"),e}function i(n){var t=p;if(s?n=s(n,r):o&&(n=n.replace(/\n/g,function(){return p++,"$line="+p+";"})),0===n.indexOf("=")){var a=f&&!/^=[=#]/.test(n);if(n=n.replace(/^=[=#]?|[\s;]*$/g,""),a){var i=n.replace(/\s*\([^\)]+\)/,"");$[i]||/^(include|print)$/.test(i)||(n="$escape("+n+")")}else n="$string("+n+")";n=v[1]+n+v[2]}return o&&(n="$line="+t+";"+n),m(e(n),function(e){if(e&&!g[e]){var n;n="print"===e?b:"include"===e?w:$[e]?"$utils."+e:d[e]?"$helpers."+e:"$data."+e,x+=e+"="+n+",",g[e]=!0}}),n+"\n"}var o=r.debug,c=r.openTag,l=r.closeTag,s=r.parser,u=r.compress,f=r.escape,p=1,g={$data:1,$filename:1,$utils:1,$helpers:1,$out:1,$line:1},h="".trim,v=h?["$out='';","$out+=",";","$out"]:["$out=[];","$out.push(",");","$out.join('')"],y=h?"$out+=text;return $out;":"$out.push(text);",b="function(){var text=''.concat.apply('',arguments);"+y+"}",w="function(filename,data){data=data||$data;var text=$utils.$include(filename,data,$filename);"+y+"}",x="'use strict';var $utils=this,$helpers=$utils.$helpers,"+(o?"$line=0,":""),j=v[0],T="return new String("+v[3]+");";m(t.split(c),function(e){e=e.split(l);var n=e[0],t=e[1];1===e.length?j+=a(n):(j+=i(n),t&&(j+=a(t)))});var k=x+j+T;o&&(k="try{"+k+"}catch(e){throw {filename:$filename,name:'Render Error',message:e.message,line:$line,source:"+n(t)+".split(/\\n/)[$line-1].replace(/^[\\s\\t]+/,'')};}");try{var E=new Function("$data","$filename",k);return E.prototype=$,E}catch(e){throw e.temp="function anonymous($data,$filename) {"+k+"}",e}}var r=function(e,n){return"string"==typeof n?h(n,{filename:e}):o(e,n)};r.version="3.0.0",r.config=function(e,n){a[e]=n};var a=r.defaults={openTag:"<%",closeTag:"%>",escape:!0,cache:!0,compress:!1,parser:null},i=r.cache={};r.render=function(e,n){return h(e,n)};var o=r.renderFile=function(e,n){var t=r.get(e)||g({filename:e,name:"Render Error",message:"Template not found"});return n?t(n):t};r.get=function(e){var n;if(i[e])n=i[e];else if("object"==typeof document){var t=document.getElementById(e);if(t){var r=(t.value||t.innerHTML).replace(/^\s*|\s*$/g,"");n=h(r,{filename:e})}}return n};var c=function(e,n){return"string"!=typeof e&&(n=typeof e,"number"===n?e+="":e="function"===n?c(e.call(e)):""),e},l={"<":"&#60;",">":"&#62;",'"':"&#34;","'":"&#39;","&":"&#38;"},s=function(e){return l[e]},u=function(e){return c(e).replace(/&(?![\w#]+;)|[<>"']/g,s)},f=Array.isArray||function(e){return"[object Array]"==={}.toString.call(e)},p=function(e,n){var t,r;if(f(e))for(t=0,r=e.length;r>t;t++)n.call(e,e[t],t,e);else for(t in e)n.call(e,e[t],t)},$=r.utils={$helpers:{},$include:o,$string:c,$escape:u,$each:p};r.helper=function(e,n){d[e]=n};var d=r.helpers=$.$helpers;r.onerror=function(e){var n="Template Error\n\n";for(var t in e)n+="<"+t+">\n"+e[t]+"\n\n";"object"==typeof console&&console.error(n)};var g=function(e){return r.onerror(e),function(){return"{Template Error}"}},h=r.compile=function(e,n){function r(t){try{return new l(t,c)+""}catch(r){return n.debug?g(r)():(n.debug=!0,h(e,n)(t))}}n=n||{};for(var o in a)void 0===n[o]&&(n[o]=a[o]);var c=n.filename;try{var l=t(e,n)}catch(e){return e.filename=c||"anonymous",e.name="Syntax Error",g(e)}return r.prototype=l.prototype,r.toString=function(){return l.toString()},c&&n.cache&&(i[c]=r),r},m=$.$each,v="break,case,catch,continue,debugger,default,delete,do,else,false,finally,for,function,if,in,instanceof,new,null,return,switch,this,throw,true,try,typeof,var,void,while,with,abstract,boolean,byte,char,class,const,double,enum,export,extends,final,float,goto,implements,import,int,interface,long,native,package,private,protected,public,short,static,super,synchronized,throws,transient,volatile,arguments,let,yield,undefined",y=/\/\*[\w\W]*?\*\/|\/\/[^\n]*\n|\/\/[^\n]*$|"(?:[^"\\]|\\[\w\W])*"|'(?:[^'\\]|\\[\w\W])*'|[\s\t\n]*\.[\s\t\n]*[$\w\.]+/g,b=/[^\w$]+/g,w=new RegExp(["\\b"+v.replace(/,/g,"\\b|\\b")+"\\b"].join("|"),"g"),x=/^\d[^,]*|,\d[^,]*/g,j=/^,+|,+$/g;a.openTag="{{",a.closeTag="}}";var T=function(e,n){var t=n.split(":"),r=t.shift(),a=t.join(":")||"";return a&&(a=", "+a),"$helpers."+r+"("+e+a+")"};a.parser=function(e,n){e=e.replace(/^\s/,"");var t=e.split(" "),a=t.shift(),i=t.join(" ");switch(a){case"if":e="if("+i+"){";break;case"else":t="if"===t.shift()?" if("+t.join(" ")+")":"",e="}else"+t+"{";break;case"/if":e="}";break;case"each":var o=t[0]||"$data",c=t[1]||"as",l=t[2]||"$value",s=t[3]||"$index",u=l+","+s;"as"!==c&&(o="[]"),e="$each("+o+",function("+u+"){";break;case"/each":e="});";break;case"echo":e="print("+i+");";break;case"print":case"include":e=a+"("+t.join(",")+");";break;default:if(-1!==i.indexOf("|")){var f=n.escape;0===e.indexOf("#")&&(e=e.substr(1),f=!1);for(var p=0,$=e.split("|"),d=$.length,g=f?"$escape":"$string",h=g+"("+$[p++]+")";d>p;p++)h=T(h,$[p]);e="=#"+h}else e=r.helpers[a]?"=#"+a+"("+t.join(",")+");":"="+e}return e},"function"==typeof define?define("util/template",[],function(){return r}):"undefined"!=typeof exports?module.exports=r:this.template=r}();